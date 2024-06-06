package org.pcs.codingsolutions.util.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringStarsRemoverTest {

    @ParameterizedTest
    @MethodSource
    void testRemovePrefix(String input, String expected) {
        // when
        String actual = StringStarsRemover.removeStars(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testRemovePrefix() {
        return Stream.of(
                Arguments.of("some*", "som"),
                Arguments.of("leet**cod*e", "lecoe"),
                Arguments.of("erase*****", "")
        );
    }
}