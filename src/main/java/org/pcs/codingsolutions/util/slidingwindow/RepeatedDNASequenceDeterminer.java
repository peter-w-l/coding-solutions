package org.pcs.codingsolutions.util.slidingwindow;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution for:
 * <p>
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 * For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings)
 * that occur more than once in a DNA molecule. You may return the answer in any order.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s[i] is either 'A', 'C', 'G', or 'T'.
 */
@UtilityClass
public class RepeatedDNASequenceDeterminer {
    public List<String> findRepeatedDnaSequences(String sourceString) {
        int sourceStringLength = sourceString.length();
        if (sourceStringLength < 11) {
            return List.of();
        }
        Set<String> allSubstrings = new HashSet<>();
        Set<String> repeatedSubstrings = new HashSet<>();

        for (int beginIndex = 0; beginIndex <= sourceStringLength - 10; beginIndex++) {
            String substring = sourceString.substring(beginIndex, beginIndex + 10);
            if (allSubstrings.contains(substring)) {
                repeatedSubstrings.add(substring);
            } else {
                allSubstrings.add(substring);
            }
        }

        return new ArrayList<>(repeatedSubstrings);
    }
}
