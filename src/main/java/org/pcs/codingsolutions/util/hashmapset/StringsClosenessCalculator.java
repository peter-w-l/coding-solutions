package org.pcs.codingsolutions.util.hashmapset;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for:
 * <p>
 * Two strings are considered close if you can attain one from the other using the following operations:
 * <p>
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 * <p>
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringsClosenessCalculator {
    public static boolean areStringsClose(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        if (word1.equals(word2)) {
            return true;
        }
        Map<Character, Integer> word1UniqueCharactersToCount = buildUniqueCharactersToCountMap(word1);
        Map<Character, Integer> word2UniqueCharactersToCount = buildUniqueCharactersToCountMap(word2);

        if (!word1UniqueCharactersToCount.keySet().equals(word2UniqueCharactersToCount.keySet())) {
            return false;
        }

        List<Integer> word1UniqueCharactersCounts = new ArrayList<>(word1UniqueCharactersToCount.values());
        List<Integer> word2UniqueCharactersCounts = new ArrayList<>(word2UniqueCharactersToCount.values());

        Collections.sort(word1UniqueCharactersCounts);
        Collections.sort(word2UniqueCharactersCounts);

        return word1UniqueCharactersCounts.equals(word2UniqueCharactersCounts);
    }

    private static Map<Character, Integer> buildUniqueCharactersToCountMap(String word) {
        Map<Character, Integer> wordUniqueCharactersToCount = new HashMap<>();
        char[] wordChars = word.toCharArray();
        for (char wordChar : wordChars) {
            wordUniqueCharactersToCount.put(wordChar, wordUniqueCharactersToCount.getOrDefault(wordChar, 0) + 1);
        }
        return wordUniqueCharactersToCount;
    }
}
