package org.pcs.codingsolutions.util.stack;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;
import java.util.Deque;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringDecoder {
    public static String decode(String source) {
        Deque<Integer> numberStack = new ArrayDeque<>();
        Deque<StringBuilder> textStack = new ArrayDeque<>();
        StringBuilder numberPart = new StringBuilder();
        StringBuilder textPart = new StringBuilder();
        int index = 0;
        while (index < source.length()) {
            char current = source.charAt(index);
            if (current == '[') {
                textStack.push(textPart);
                textPart = new StringBuilder();
            } else if (current == ']') {
                int number = numberStack.pop();
                StringBuilder prefix = textStack.pop();
                StringBuilder decodedPartInBrackets = repeatString(textPart, number);
                textPart = prefix.append(decodedPartInBrackets);
            } else if (Character.isDigit(current)) {
                numberPart.append(current);
                while (Character.isDigit(source.charAt(index + 1))) {
                    numberPart.append(source.charAt(index + 1));
                    index ++;
                }
                numberStack.push(Integer.parseInt(numberPart.toString()));
                numberPart = new StringBuilder();
            } else {
                textPart.append(current);
            }
            index ++;
        }

        return textPart.toString();
    }

    private static StringBuilder repeatString(StringBuilder source, int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(source);
        }
        return result;
    }

}
