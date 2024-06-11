package org.pcs.codingsolutions.util.queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class VotingCalculatorTest {

    @ParameterizedTest
    @MethodSource
    void testPredictPartyVictory(String participants, String expected) {
        // when
        String actual = VotingCalculator.predictPartyVictory(participants);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testPredictPartyVictory() {
        return Stream.of(
                Arguments.of("RD", "Radiant"),
                Arguments.of("RDD", "Dire"),
                Arguments.of("DDRRR", "Dire")
        );
    }
}