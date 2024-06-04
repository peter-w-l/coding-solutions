package org.pcs.codingsolutions.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class VowelsOfSubstringCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testGetMaxNumberOfVowelsInSubstring(String source, int substringLength, int expected) {
        // when
        int actual = VowelsOfSubstringCalculator.getMaxNumberOfVowelsInSubstring(source, substringLength);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetMaxNumberOfVowelsInSubstring() {
        return Stream.of(
                Arguments.of("abciiidef", 3, 3),
                Arguments.of("aeiou", 2, 2),
                Arguments.of("leetcode", 3, 2)
        );
    }
}