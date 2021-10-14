package maths;

import java.util.stream.Stream;
import org.exercices.modules.Maths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Eratosthene {

	@ParameterizedTest
	@MethodSource("eratostheneProvider")
	public void eratosthene(final long nProvided, final long eratostheneExpected) {
		// actual
		final long eratostheneActual = Maths.eratosthene(nProvided);

		// assert
		Assertions.assertEquals(eratostheneExpected, eratostheneActual);
	}

	private static Stream<Arguments> eratostheneProvider() {
		return Stream.of(
				Arguments.of(-1, -1),
				Arguments.of(0, -1),
				Arguments.of(1, 0),
				Arguments.of(2, 1),
				Arguments.of(3, 2),
				Arguments.of(4, 2),
				Arguments.of(5, 3),
				Arguments.of(6, 3),
				Arguments.of(7, 4),
				Arguments.of(8, 4),
				Arguments.of(9, 4),
				Arguments.of(10, 4),
				Arguments.of(20, 8),
				Arguments.of(100, 25),
				Arguments.of(1_000, 168)
		);
	}

}
