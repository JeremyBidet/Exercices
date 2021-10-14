package maths;

import java.util.stream.Stream;
import org.exercices.modules.Maths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PPCM {

	@ParameterizedTest
	@MethodSource("ppcmProvider")
	public void ppcm(final long aProvided, final long bProvided, final long ppcmExpected) {
		// actual
		final long ppcmActual = Maths.ppcm(aProvided, bProvided);

		// assert
		Assertions.assertEquals(ppcmExpected, ppcmActual);
	}

	private static Stream<Arguments> ppcmProvider() {
		return Stream.of(
				Arguments.of(0, 0, 0),
				Arguments.of(0, 1, 0),
				Arguments.of(1, 1, 1),
				Arguments.of(2, 1, 2),
				Arguments.of(2, 3, 6),
				Arguments.of(45, 12, 180),
				Arguments.of(642, 87, 18_618),
				Arguments.of(-1, 0, -1),
				Arguments.of(-5, -25, -1)
		);
	}

}
