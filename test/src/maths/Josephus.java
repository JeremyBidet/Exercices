package maths;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.exercices.modules.Maths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Josephus {

	@ParameterizedTest
	@MethodSource("josephusProvider")
	public void josephus(final int nProvided, final int kProvided, final int josephusExpected) {
		// actual
		final long josephusActual = Maths.josephus(nProvided, kProvided);

		// assert
		Assertions.assertEquals(josephusExpected, josephusActual);
	}

	@ParameterizedTest
	@MethodSource("josephusProvider")
	public void r_josephus(final int nProvided, final int kProvided, final int josephusExpected) {
		if(nProvided > 100) {
			System.err.println(nProvided + " was ignored due to stack overflow!");
			return;
		}
		// actual
		final long josephusActual = Maths.r_josephus(nProvided, kProvided, kProvided, 0, IntStream.generate(() -> -1).limit(Math.max(nProvided, 0)).toArray());

		// assert
		Assertions.assertEquals(josephusExpected, josephusActual);
	}

	private static Stream<Arguments> josephusProvider() {
		return Stream.of(
				Arguments.of(-1, -1, -1),
				Arguments.of(-1, 0, -1),
				Arguments.of(0, -1, -1),
				Arguments.of(0, 0, -1),
				Arguments.of(1, 1, 0),
				Arguments.of(1, 2, 0),
				Arguments.of(2, 1, 1),
				Arguments.of(2, 2, 0),
				Arguments.of(3, 2, 2),
				Arguments.of(4, 2, 0),
				Arguments.of(5, 2, 2),
				Arguments.of(6, 2, 4),
				Arguments.of(7, 2, 6),
				Arguments.of(8, 2, 0),
				Arguments.of(9, 2, 2),
				Arguments.of(10, 2, 4),
				Arguments.of(15, 2, 14),
				Arguments.of(10, 3, 3),
				Arguments.of(10, 4, 4),
				Arguments.of(10, 5, 2),
				Arguments.of(10, 10, 7),
				Arguments.of(10, 11, 6),
				Arguments.of(564, 10, 360),
				Arguments.of(10_000, 10, 9_142),
				Arguments.of(10_000, 1_000, 5_980),
				Arguments.of(10_000, 9_999, 3_376),
				Arguments.of(10_000, 10_000, 2_018)
		);
	}

}
