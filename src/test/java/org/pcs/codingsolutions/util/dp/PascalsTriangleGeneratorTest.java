package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PascalsTriangleGeneratorTest {

    @ParameterizedTest
    @MethodSource
    void testGenerateRow(int input, List<Integer> expected) {
        // when
        List<Integer> actual = PascalsTriangleGenerator.generateRow(input);

        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    private static Stream<Arguments> testGenerateRow() {
        return Stream.of(
                Arguments.of(4, List.of(1,4,6,4,1)),
                Arguments.of(3, List.of(1,3,3,1)),
                Arguments.of(0, List.of(1)),
                Arguments.of(1, List.of(1,1))
        );
    }

    @ParameterizedTest
    @MethodSource
    void testGenerate(int input, List<List<Integer>> expected) {
        // when
        List<List<Integer>> actual = PascalsTriangleGenerator.generate(input);

        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    private static Stream<Arguments> testGenerate() {
        return Stream.of(
                Arguments.of(5,
                        List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1, 4, 6, 4, 1))),
                Arguments.of(1, List.of(List.of(1)))
        );
    }
}