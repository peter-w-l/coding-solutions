package org.pcs.codingsolutions.util.hashmapset;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringsClosenessCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testAreStringsClose(String leftString, String rightString, boolean expected) {
        // when
        var actual = StringsClosenessCalculator.areStringsClose(leftString, rightString);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testAreStringsClose() {
        return Stream.of(
                Arguments.of("abc", "bca", true),
                Arguments.of("a", "aa", false),
                Arguments.of("cabbba", "abbccc", true),
                Arguments.of("abbzzca", "babzzcz", false)
        );
    }
}