package org.pcs.codingsolutions.util.stack;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Solution for:
 * <p>
 * You are given a string s, which contains stars *.
 * <p>
 * In one operation, you can:
 * <p>
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 * <p>
 * Note:
 * <p>
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringStarsRemover {
    public static String removeStars(String input) {
        int inputLength = input.length();

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < inputLength; i++) {
            char inputChar = input.charAt(i);
            if (inputChar == '*') {
                output.deleteCharAt(output.length() - 1);
            } else {
                output.append(inputChar);
            }
        }
        return output.toString();
    }
}
