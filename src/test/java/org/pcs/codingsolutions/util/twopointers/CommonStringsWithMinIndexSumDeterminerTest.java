package org.pcs.codingsolutions.util.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CommonStringsWithMinIndexSumDeterminerTest {

    @ParameterizedTest
    @MethodSource
    void testGetCommonStringWithMinIndexSum(String[] list1,String[] list2, String[] expected) {
        // when
        String[] actual = CommonStringsWithMinIndexSumDeterminer.getCommonStringWithMinIndexSum(list1, list2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testGetCommonStringWithMinIndexSum() {
        return Stream.of(
                Arguments.of(new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                        new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"},
                         new String[]{"Shogun"}),
                Arguments.of(new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                        new String[]{"KFC","Shogun","Burger King"},
                        new String[]{"Shogun"}),
                Arguments.of(new String[]{"happy","sad","good"},
                        new String[]{"sad","happy","good"},
                        new String[]{"sad","happy"})
        );
    }
}