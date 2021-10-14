package maths;

import java.util.stream.Stream;
import org.exercices.answers.Maths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PGCD {

	@ParameterizedTest
	@MethodSource("pgcdProvider")
	public void pgcd(final long aProvided, final long bProvided, final long pgcdExpected) {
		// actual
		final long pgcdActual = Maths.pgcd(aProvided, bProvided);

		// assert
		Assertions.assertEquals(pgcdExpected, pgcdActual);
	}

	@ParameterizedTest
	@MethodSource("pgcdProvider")
	public void r_pgcd(final long aProvided, final long bProvided, final long pgcdExpected) {
		// actual
		final long pgcdActual = Maths.r_pgcd(aProvided, bProvided);

		// assert
		Assertions.assertEquals(pgcdExpected, pgcdActual);
	}

	private static Stream<Arguments> pgcdProvider() {
		return Stream.of(
				Arguments.of(0, 0, -1),
				Arguments.of(0, 1, -1),
				Arguments.of(1, 1, 1),
				Arguments.of(2, 1, 1),
				Arguments.of(15, 5, 5),
				Arguments.of(154, 55, 11),
				Arguments.of(1_679, 713, 23),
				Arguments.of(1_035, 54_675, 45),
				Arguments.of(-5, -25, -1)
		);
	}

}
