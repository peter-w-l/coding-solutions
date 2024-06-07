package org.pcs.codingsolutions.util.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringDecoderTest {

    @ParameterizedTest
    @MethodSource
    void testDecode(String source, String expected) {
        // when
        String actual = StringDecoder.decode(source);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testDecode() {
        return Stream.of(
                Arguments.of("3[a]2[bc]", "aaabcbc"),
                Arguments.of("10[a]2[bc]", "aaaaaaaaaabcbc"),
                Arguments.of("3[a2[c]]", "accaccacc"),
                Arguments.of("2[abc]3[cd]ef", "abcabccdcdcdef"),
                Arguments.of("x2[a3[b]some]awesome", "xabbbsomeabbbsomeawesome")
        );
    }
}