package maths;

import java.util.Arrays;
import java.util.stream.Stream;
import org.exercices.modules.Maths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BiZaries {

	@ParameterizedTest
	@MethodSource("itobProvider")
	public void itob(final int aProvided, final String bitsExpected) {
		// actual
		final int[] bitsActual = Maths.itob(aProvided);

		// assert
		Assertions.assertEquals(bitsExpected, btos(bitsActual));
	}

	private static Stream<Arguments> itobProvider() {
		return Stream.of(
				Arguments.of(0, "00000000000000000000000000000000"),
				Arguments.of(1, "00000000000000000000000000000001"),
				Arguments.of(2, "00000000000000000000000000000010"),
				Arguments.of(2_147_483_646, "01111111111111111111111111111110"),
				Arguments.of(2_147_483_647, "01111111111111111111111111111111"),
				Arguments.of(-2_147_483_648, "10000000000000000000000000000000"),
				Arguments.of(-2_147_483_647, "10000000000000000000000000000001"),
				Arguments.of(-2, "11111111111111111111111111111110"),
				Arguments.of(-1, "11111111111111111111111111111111")
		);
	}

	private static String btos(final int[] bits) {
		return Arrays.stream(bits).boxed().map(String::valueOf).reduce(String::concat).orElse("");
	}

}
