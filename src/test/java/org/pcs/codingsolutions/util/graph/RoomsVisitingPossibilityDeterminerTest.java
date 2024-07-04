package org.pcs.codingsolutions.util.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RoomsVisitingPossibilityDeterminerTest {

    @ParameterizedTest
    @MethodSource
    void testCanVisitAllRooms(List<List<Integer>> rooms, boolean expected) {
        // given - when
        boolean actual = RoomsVisitingPossibilityDeterminer.canVisitAllRooms(rooms);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testCanVisitAllRooms() {
        return Stream.of(
                Arguments.of(List.of(List.of(1), List.of(2), List.of(3), List.of()), true),
                Arguments.of(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0)), false)
        );
    }
}