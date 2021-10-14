package finder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.exercices.modules.Finder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Dichotomie {

	@ParameterizedTest
	@MethodSource("dichotomieProvider")
	public void dichotomie(final int targetProvided, final int positionExpected) {
		// actual
		final int positionActual = Finder.dichotomie(dataProvided, targetProvided);

		// assert
		Assertions.assertEquals(positionExpected, positionActual);
	}

	@ParameterizedTest
	@MethodSource("dichotomieProvider")
	public void r_dichotomie(final int targetProvided, final int positionExpected) {
		// actual
		final int positionActual = Finder.r_dichotomie(dataProvided, targetProvided, positionInitial, 0, dataProvided.length - 1, -1);

		// assert
		Assertions.assertEquals(positionExpected, positionActual);
	}

	@Disabled
	@ParameterizedTest
	@MethodSource("dichotomieProvider")
	public void r_dichotomie2(final int targetProvided, final int positionExpected) {
		// actual
		List<Integer> dataList = Arrays.stream(dataProvided).boxed().collect(Collectors.toList());
		final int positionActual = org.exercices.answers.Finder.r_dichotomie2(dataList, targetProvided, 0);

		// assert
		Assertions.assertEquals(positionExpected, positionActual);
	}

	private static Stream<Arguments> dichotomieProvider() {
		return Stream.of(
				Arguments.of(-1, -1),
				Arguments.of(0, -1),
				Arguments.of(1, -1),
				Arguments.of(5, 0),
				Arguments.of(16, 1),
				Arguments.of(24, 2),
				Arguments.of(296, 29),
				Arguments.of(5_119_793, 511_979),
				Arguments.of(6_969_062, 696_906),
				Arguments.of(6_969_068, -1),
				Arguments.of(9_999_983, 999_998),
				Arguments.of(9_999_999, 999_999)
		);
	}

	private static final Path dataFile = Paths.get("test/resources/data.db");
	private static int positionInitial;
	private static int[] dataProvided;
	static {
		try(final BufferedReader br = Files.newBufferedReader(dataFile)) {
			final String[] values = br.readLine().split(",");
			final int dataSize = values.length;
			dataProvided = new int[dataSize];
			positionInitial = dataSize / 2;
			int i = 0;
			for(final String value : values) {
				dataProvided[i++] = Integer.parseInt(value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Disabled
	@Test
	public void createRandomDataFile() {
		final ThreadLocalRandom tlr = ThreadLocalRandom.current();

		final int rngStep = 10;
		final int dataSize = 1_000_000;
		final int maxHit = (int) (Math.log10(dataSize) / Math.log10(2));
		final int positionInitial = dataSize / 2;

		System.out.println("dataSize: " + dataSize);
		System.out.println("rngStep: " + rngStep);
		System.out.println("maxHit: " + maxHit);
		System.out.println("positionInitial: " + positionInitial);

		final Path dataFile = Paths.get("test/resources/data.db");
		try(final BufferedWriter bw = Files.newBufferedWriter(dataFile, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
			IntStream.range(0, dataSize)
					.map(i -> tlr.nextInt(i * rngStep, i * rngStep + rngStep))
					.mapToObj(String::valueOf)
					.forEach(str -> {
						try {
							bw.write(str);
							bw.write(',');
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
			final RandomAccessFile raf = new RandomAccessFile(dataFile.toFile(), "rw");
			// there's currently an error with raf.length() and File.length(), both returning 7_872_512 bytes instead of 7_888_889
			raf.seek(7_888_888);
			raf.write(-1);
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
