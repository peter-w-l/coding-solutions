package org.pcs.codingsolutions.util.twopointers;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
@UtilityClass
public class StringReverseProcessor {
    public void reverseString(char[] sourceString) {
        int beginIndex = 0;
        int endIndex = sourceString.length - 1;
        char currentChar;
        while(beginIndex < endIndex) {
            currentChar = sourceString[beginIndex];
            sourceString[beginIndex] = sourceString[endIndex];
            sourceString[endIndex] = currentChar;
            beginIndex ++;
            endIndex --;
        }
    }
}
