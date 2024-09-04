package org.pcs.codingsolutions.util.slidingwindow;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase.
 * For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear.
 * However, "abA" is not because 'b' appears, but 'B' does not.
 * <p>
 * Given a string s, return the longest substring of s that is nice.
 * If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s consists of uppercase and lowercase English letters.
 */
@UtilityClass
public class LongestNiceSubstringCalculator {
    public String getLongestNiceSubstring(String sourceString) {
        char[] sourceStringChars = sourceString.toCharArray();

        var substring = getLongestNiceSubstring(new Substring(
                sourceString,
                sourceStringChars,
                0,
                sourceStringChars.length - 1));
        return substring.asString();

    }

    private Substring getLongestNiceSubstring(Substring substring) {
        if (substring.getBeginIndex() > substring.getEndIndex()) {
            return Substring.EMPTY;
        }

        for (int i = substring.getBeginIndex(); i <= substring.getEndIndex(); i++) {
            char currentChar = substring.getOriginalStringChars()[i];
            if (!substring.contains(Character.toLowerCase(currentChar))
                    || !substring.contains(Character.toUpperCase(currentChar))) {
                Substring left = getLongestNiceSubstring(new Substring(
                        substring.getOriginalString(),
                        substring.getOriginalStringChars(),
                        substring.getBeginIndex(),
                        i - 1));
                Substring right = getLongestNiceSubstring(new Substring(
                        substring.getOriginalString(),
                        substring.getOriginalStringChars(),
                        i + 1,
                        substring.getEndIndex()));
                if (left.isEmpty()) {
                    return right;
                }
                if (right.isEmpty()) {
                    return left;
                }
                return left.getEndIndex() - left.getBeginIndex() >= right.getEndIndex() - right.getBeginIndex()
                        ? left : right;
            }
        }
        return substring;
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private class Substring {
        public static final Substring EMPTY = new Substring("", new char[0], 0, 0, new boolean[0], new boolean[0]);

        private final String originalString;
        private final char[] originalStringChars;
        private final int beginIndex;
        private final int endIndex;

        private final boolean[] lowerCaseCharsOccurrences;
        private final boolean[] upperCaseCharsOccurrences;

        public Substring(String originalString,
                         char[] originalStringChars,
                         int beginIndex,
                         int endIndex) {
            this.originalString = originalString;
            this.originalStringChars = originalStringChars;
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;

            this.lowerCaseCharsOccurrences = new boolean[26];
            this.upperCaseCharsOccurrences = new boolean[26];
            initCharsOccurrences();
        }

        private void initCharsOccurrences() {
            for (int i = beginIndex; i <= endIndex; i++) {
                char currentChar = originalStringChars[i];
                if (Character.isLowerCase(currentChar)) {
                    lowerCaseCharsOccurrences[currentChar - 'a'] = true;
                } else {
                    upperCaseCharsOccurrences[currentChar - 'A'] = true;
                }
            }
        }

        private boolean contains(char charToVerify) {
            if (Character.isLowerCase(charToVerify)) {
                return lowerCaseCharsOccurrences[charToVerify - 'a'];
            } else {
                return upperCaseCharsOccurrences[charToVerify - 'A'];
            }
        }

        private String asString() {
            return isEmpty() ? "" : originalString.substring(beginIndex, endIndex + 1);
        }

        private boolean isEmpty() {
            return this == EMPTY;
        }
    }
}
