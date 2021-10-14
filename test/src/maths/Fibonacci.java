package maths;

import java.util.stream.Stream;
import org.exercices.modules.Maths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Fibonacci {

	@ParameterizedTest
	@MethodSource("fibonacciProvider")
	public void fibonacci(final long nProvided, final long fibonacciExpected) {
		// actual
		final long fibonacciActual = Maths.fibonacci(nProvided);

		// assert
		Assertions.assertEquals(fibonacciExpected, fibonacciActual);
	}

	@ParameterizedTest
	@MethodSource("fibonacciProvider")
	public void r_fibonacci(final long nProvided, final long fibonacciExpected) {
		// actual
		final long fibonacciActual = Maths.r_fibonacci(nProvided);

		// assert
		Assertions.assertEquals(fibonacciExpected, fibonacciActual);
	}

	private static Stream<Arguments> fibonacciProvider() {
		return Stream.of(
				Arguments.of(-1, -1),
				Arguments.of(0, 0),
				Arguments.of(1, 1),
				Arguments.of(2, 1),
				Arguments.of(3, 2),
				Arguments.of(4, 3),
				Arguments.of(5, 5),
				Arguments.of(6, 8),
				Arguments.of(7, 13),
				Arguments.of(10, 55),
				Arguments.of(50, 12_586_269_025L)
		);
	}

}
