package org.pcs.codingsolutions.util.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringReverseProcessorTest {
    @ParameterizedTest
    @MethodSource
    void testReverseString(char[] input, char[] expected) {
        // when
        StringReverseProcessor.reverseString(input);

        // then
        assertThat(input).isEqualTo(expected);
    }

    /**
     * Example 1:
     * Input: s = ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     * <p>
     * Example 2:
     * Input: s = ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     */
    @SuppressWarnings("unused")
    private static Stream<Arguments> testReverseString() {
        return Stream.of(
                Arguments.of(new char[] {'h','e','l','l','o'}, new char[] {'o','l','l','e','h'}),
                Arguments.of(new char[] {'H','a','n','n','a','h'}, new char[] {'h','a','n','n','a','H'})
        );
    }

}