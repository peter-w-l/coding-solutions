package org.pcs.codingsolutions.util.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestNiceSubstringCalculatorTest {
    @ParameterizedTest
    @MethodSource
    void test(String input, String expected) {
        // when
        String actual = LongestNiceSubstringCalculator.getLongestNiceSubstring(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of("wWOExoVhvXebB", "wW"),
                Arguments.of("dDzeE", "dD"),
                Arguments.of("abcCdDBe", "bcCdDB"),
                Arguments.of("cChH", "cChH"),
                Arguments.of("YazaAay", "aAa"),
                Arguments.of("Bb", "Bb"),
                Arguments.of("c", "")
        );
    }

}