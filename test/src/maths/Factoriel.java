package maths;

import java.util.stream.Stream;
import org.exercices.modules.Maths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Factoriel {

	@ParameterizedTest
	@MethodSource("factorielProvider")
	public void factoriel(final long nProvided, final long factorielExpected) {
		// actual
		final long factorielActual = Maths.factoriel(nProvided);

		// assert
		Assertions.assertEquals(factorielExpected, factorielActual);
	}

	@ParameterizedTest
	@MethodSource("factorielProvider")
	public void r_factoriel(final long nProvided, final long factorielExpected) {
		// actual
		final long factorielActual = Maths.r_factoriel(nProvided);

		// assert
		Assertions.assertEquals(factorielExpected, factorielActual);
	}

	private static Stream<Arguments> factorielProvider() {
		return Stream.of(
				Arguments.of(-1, -1),
				Arguments.of(0, 1),
				Arguments.of(1, 1),
				Arguments.of(2, 2),
				Arguments.of(3, 6),
				Arguments.of(4, 24),
				Arguments.of(5, 120),
				Arguments.of(10, 3_628_800L),
				Arguments.of(20, 2_432_902_008_176_640_000L),
				Arguments.of(25, 7_034_535_277_573_963_776L)
		);
	}

}
