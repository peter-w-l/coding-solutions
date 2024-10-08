package org.pcs.codingsolutions.util.dp;

import lombok.experimental.UtilityClass;

import java.util.List;

/**
 * Solution for:
 * <p>
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
@UtilityClass
public class WordBreakDeterminer {
    public boolean canBreakUsingDictionary(String sourceWord, List<String> wordDict) {
        boolean[] wordBreakPossibilityByIndex = new boolean[sourceWord.length() + 1];

        //base case
        wordBreakPossibilityByIndex[0] = true; // it is possible to break sourceWord with wordDict words until index 0

        for (int fromIndex = 0; fromIndex < wordBreakPossibilityByIndex.length - 1; fromIndex++) {
            if (!wordBreakPossibilityByIndex[fromIndex]) {
                continue;
            }
            for (String dictionaryWord : wordDict) {
                if (sourceWord.indexOf(dictionaryWord, fromIndex) == fromIndex) {
                    wordBreakPossibilityByIndex[fromIndex + dictionaryWord.length()] = true;
                }
            }
        }
        return wordBreakPossibilityByIndex[wordBreakPossibilityByIndex.length - 1];
    }
}
