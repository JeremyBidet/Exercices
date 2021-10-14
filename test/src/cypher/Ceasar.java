package cypher;

import java.util.stream.Stream;
import org.exercices.answers.Cypher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Ceasar {

	@ParameterizedTest
	@MethodSource("ceaserEncryptProvider")
	public void cypherCeasarEncrypt(final char[] sourceProvided, final int keyProvided, final char[] cypherExpected) {
		// actual
		final char[] cypherActual = Cypher.ceasarEncrypt(sourceProvided, keyProvided);

		// assert
		Assertions.assertArrayEquals(cypherExpected, cypherActual);
	}

	@ParameterizedTest
	@MethodSource("ceaserDecryptProvider")
	public void cypherCeasarDecrypt(final char[] sourceExpected, final int keyProvided, final char[] cypherProvided) {
		// actual
		final char[] sourceActual = Cypher.ceasarDecrypt(cypherProvided, keyProvided);

		// assert
		Assertions.assertArrayEquals(sourceExpected, sourceActual);
	}

	private static final char[] invalid = "A1b2C3".toCharArray();
	private static final char[] source = "ABCDEF".toCharArray();
	private static final char[] source_lc = "aBcdEf".toCharArray();

	private static Stream<Arguments> ceaserEncryptProvider() {
		return Stream.of(
				Arguments.of(null, 0, new char[0]),
				Arguments.of(new char[]{}, 0, new char[0]),
				Arguments.of(invalid, 2, new char[0]),
				Arguments.of(source, 0, source),
				Arguments.of(source, 1, "BCDEFG".toCharArray()),
				Arguments.of(source, 2, "CDEFGH".toCharArray()),
				Arguments.of(source, 3, "DEFGHI".toCharArray()),
				Arguments.of(source, 13, "NOPQRS".toCharArray()),
				Arguments.of(source, 25, "ZABCDE".toCharArray()),
				Arguments.of(source, 26, "ABCDEF".toCharArray()),
				Arguments.of(source, -1, "ZABCDE".toCharArray()),
				Arguments.of(source, -2, "YZABCD".toCharArray()),
				Arguments.of(source, -13, "NOPQRS".toCharArray()),
				Arguments.of(source, -26, "ABCDEF".toCharArray()),
				Arguments.of(source_lc, 0, "ABCDEF".toCharArray()),
				Arguments.of(source_lc, 2, "CDEFGH".toCharArray())
		);
	}

	private static Stream<Arguments> ceaserDecryptProvider() {
		return Stream.of(
				Arguments.of(new char[0], 0, null), // only for Decrypt (cypher cannot be null in Encrypt)
				Arguments.of(new char[0], 0, new char[]{}),
				Arguments.of(new char[0], 2, invalid),
				Arguments.of(source, 0, source),
				Arguments.of(source, 1, "BCDEFG".toCharArray()),
				Arguments.of(source, 2, "CDEFGH".toCharArray()),
				Arguments.of(source, 3, "DEFGHI".toCharArray()),
				Arguments.of(source, 13, "NOPQRS".toCharArray()),
				Arguments.of(source, 25, "ZABCDE".toCharArray()),
				Arguments.of(source, 26, "ABCDEF".toCharArray()),
				Arguments.of(source, -1, "ZABCDE".toCharArray()),
				Arguments.of(source, -2, "YZABCD".toCharArray()),
				Arguments.of(source, -13, "NOPQRS".toCharArray()),
				Arguments.of(source, -26, "ABCDEF".toCharArray()),
				Arguments.of("ABCDEF".toCharArray(), 0, source_lc),
				Arguments.of("YZABCD".toCharArray(), 2, source_lc)
		);
	}

}
