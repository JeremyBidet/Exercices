package array;

import java.util.stream.Stream;
import org.exercices.modules.Array;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Dimension {

	@ParameterizedTest
	@MethodSource("dimension2Provider")
	public void dimension2(final char[][] dataProvided, final int kProvided, final char dataExpected) {
		// actual
		final char dataActual = Array.dimension2(dataProvided, kProvided);

		// assert
		Assertions.assertEquals(dataExpected, dataActual);
	}

	@ParameterizedTest
	@MethodSource("dimension2FlatProvider")
	public void dimension2Flat(final char[] dataProvided, final int widthProvided, final int iProvided, final int jProvided, final char dataExpected) {
		// actual
		final char dataActual = Array.dimension2Flat(dataProvided, widthProvided, iProvided, jProvided);

		// assert
		Assertions.assertEquals(dataExpected, dataActual);
	}

	private static final char[][] dimension2_1 = new char[][] {
			"0".toCharArray(),
			"1".toCharArray(),
			"2".toCharArray(),
			"3".toCharArray(),
			"4".toCharArray(),
			"5".toCharArray(),
			"6".toCharArray()
	};
	private static final char[][] dimension2_2 = new char[][] {
			"01234".toCharArray(),
			"56789".toCharArray(),
			"abcde".toCharArray(),
			"fghij".toCharArray(),
			"klmno".toCharArray(),
			"pqrst".toCharArray(),
			"uvwxy".toCharArray()
	};

	private static Stream<Arguments> dimension2Provider() {
		return Stream.of(
				Arguments.of(null, 0, '\0'),
				Arguments.of(new char[][]{}, 0, '\0'),
				Arguments.of(new char[][]{{}}, 0, '\0'),

				Arguments.of(dimension2_1, -1, '\0'),
				Arguments.of(dimension2_1, 0, '0'),
				Arguments.of(dimension2_1, 1, '1'),
				Arguments.of(dimension2_1, 2, '2'),
				Arguments.of(dimension2_1, 3, '3'),
				Arguments.of(dimension2_1, 5, '5'),
				Arguments.of(dimension2_1, 6, '6'),
				Arguments.of(dimension2_1, 7, '\0'),

				Arguments.of(dimension2_2, -1, '\0'),
				Arguments.of(dimension2_2, 0, '0'),
				Arguments.of(dimension2_2, 1, '1'),
				Arguments.of(dimension2_2, 2, '2'),
				Arguments.of(dimension2_2, 3, '3'),
				Arguments.of(dimension2_2, 4, '4'),
				Arguments.of(dimension2_2, 5, '5'),
				Arguments.of(dimension2_2, 10, 'a'),
				Arguments.of(dimension2_2, 12, 'c'),
				Arguments.of(dimension2_2, 15, 'f'),
				Arguments.of(dimension2_2, 19, 'j'),
				Arguments.of(dimension2_2, 20, 'k'),
				Arguments.of(dimension2_2, 28, 's'),
				Arguments.of(dimension2_2, 34, 'y'),
				Arguments.of(dimension2_2, 35, '\0')
		);
	}

	private static final char[] dimension2Flat_1 = "abcdefghijkl".toCharArray();
	private static final char[] dimension2Flat_2 = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

	private static Stream<Arguments> dimension2FlatProvider() {
		return Stream.of(
				Arguments.of(null, 0, 0, 0, '\0'),
				Arguments.of(new char[]{}, 0, 0, 0, '\0'),

				Arguments.of(dimension2Flat_1, 3, -1, 0, '\0'),
				Arguments.of(dimension2Flat_1, 3, 0, -1, '\0'),
				Arguments.of(dimension2Flat_1, 3, 0, 0, 'a'),
				Arguments.of(dimension2Flat_1, 3, 0, 1, 'b'),
				Arguments.of(dimension2Flat_1, 3, 1, 0, 'd'),
				Arguments.of(dimension2Flat_1, 3, 1, 1, 'e'),
				Arguments.of(dimension2Flat_1, 3, 3, 0, 'j'),
				Arguments.of(dimension2Flat_1, 3, 0, 2, 'c'),
				Arguments.of(dimension2Flat_1, 3, 3, 2, 'l'),
				Arguments.of(dimension2Flat_1, 3, 2, 3, '\0'),
				Arguments.of(dimension2Flat_1, 3, 9, 9, '\0'),

				Arguments.of(dimension2Flat_2, 4, -1, 0, '\0'),
				Arguments.of(dimension2Flat_2, 4, 0, -1, '\0'),
				Arguments.of(dimension2Flat_2, 4, 0, 0, 'a'),
				Arguments.of(dimension2Flat_2, 4, 0, 1, 'b'),
				Arguments.of(dimension2Flat_2, 4, 0, 3, 'd'),
				Arguments.of(dimension2Flat_2, 4, 1, 0, 'e'),
				Arguments.of(dimension2Flat_2, 4, 1, 1, 'f'),
				Arguments.of(dimension2Flat_2, 4, 1, 3, 'h'),
				Arguments.of(dimension2Flat_2, 4, 5, 0, 'u'),
				Arguments.of(dimension2Flat_2, 4, 5, 2, 'w'),
				Arguments.of(dimension2Flat_2, 4, 5, 3, 'x'),
				Arguments.of(dimension2Flat_2, 4, 8, 0, '6'),
				Arguments.of(dimension2Flat_2, 4, 8, 2, '8'),
				Arguments.of(dimension2Flat_2, 4, 8, 3, '9'),
				Arguments.of(dimension2Flat_2, 4, 8, 9, '\0'),
				Arguments.of(dimension2Flat_2, 4, 9, 3, '\0'),
				Arguments.of(dimension2Flat_2, 4, 9, 9, '\0')

		);
	}

}
