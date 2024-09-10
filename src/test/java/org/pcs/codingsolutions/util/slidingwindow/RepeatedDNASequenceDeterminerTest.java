package org.pcs.codingsolutions.util.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RepeatedDNASequenceDeterminerTest {

    @ParameterizedTest
    @MethodSource
    void testFindRepeatedDnaSequences(String input, List<String> expected) {
        // when
        List<String> actual = RepeatedDNASequenceDeterminer.findRepeatedDnaSequences(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testFindRepeatedDnaSequences() {
        return Stream.of(
                Arguments.of("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", List.of("AAAAACCCCC","CCCCCAAAAA")),
                Arguments.of("AAAAAAAAAAAAA", List.of("AAAAAAAAAA"))
        );
    }
}