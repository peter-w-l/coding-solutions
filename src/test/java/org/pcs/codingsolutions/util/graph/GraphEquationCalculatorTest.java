package org.pcs.codingsolutions.util.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GraphEquationCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testCalculateEquation(List<List<String>> equations,
                               double[] equationResults,
                               List<List<String>> queries,
                               double[] expected) {
        // given - when
        double[] actual = GraphEquationCalculator.calculateEquation(equations, equationResults, queries);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testCalculateEquation() {
        return Stream.of(
                Arguments.of(List.of(List.of("a", "b"), List.of("b", "c")),
                        new double[]{2.0, 3.0},
                        List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x")),
                        new double[]{6.00000, 0.50000, -1.00000, 1.00000, -1.00000}),

                Arguments.of(List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc", "cd")),
                        new double[]{1.5, 2.5, 5.0},
                        List.of(List.of("a", "c"), List.of("c", "b"), List.of("bc", "cd"), List.of("cd", "bc")),
                        new double[]{3.75000, 0.40000, 5.00000, 0.20000}),

                Arguments.of(List.of(List.of("a", "b")),
                        new double[]{0.5},
                        List.of(List.of("a", "b"), List.of("b", "a"), List.of("a", "c"), List.of("x", "y")),
                        new double[]{0.50000, 2.00000, -1.00000, -1.00000}),

                Arguments.of(List.of(List.of("x1", "x2"), List.of("x2", "x3"), List.of("x3", "x4"), List.of("x4", "x5")),
                        new double[]{3.0, 4.0, 5.0, 6.0},
                        List.of(List.of("x1", "x5"), List.of("x5", "x2"), List.of("x2", "x4"), List.of("x2", "x2"), List.of("x2", "x9"), List.of("x9", "x9")),
                        new double[]{360.00000, 0.008333333333333333, 20.00000, 1.00000, -1.00000, -1.00000})

        );
    }
}