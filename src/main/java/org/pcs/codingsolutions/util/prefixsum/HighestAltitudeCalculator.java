package org.pcs.codingsolutions.util.prefixsum;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Solution for:
 *
 * You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HighestAltitudeCalculator {
    public static int getHighestAltitude(int[] gain) {
        int maxAltitude = 0;
        int prefixSum = 0;
        int gainLength = gain.length;

        for (int i = 0; i < gainLength; i++) {
            prefixSum += gain[i];
            maxAltitude = Math.max(maxAltitude, prefixSum);
        }

        return maxAltitude; // Time complexity is O(N). Space complexity is O(1).
    }
}
