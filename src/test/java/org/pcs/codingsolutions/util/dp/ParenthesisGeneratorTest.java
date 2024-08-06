package org.pcs.codingsolutions.util.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ParenthesisGeneratorTest {
    @ParameterizedTest
    @MethodSource
    void testGenerateParenthesis(int input, List<String> expected) {
        // when
        List<String> actual = ParenthesisGenerator.generateParenthesis(input);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> testGenerateParenthesis() {
        return Stream.of(
                Arguments.of(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()")),
                Arguments.of(1, List.of("()"))
        );
    }
}