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
                Integer number = Integer.parseInt(numberPart.toString());
                numberStack.push(number);
                numberPart = new StringBuilder();
            } else if (current == ']') {
                int number = numberStack.pop();
                StringBuilder text = textStack.pop(); // prefix

                if (textPart.isEmpty()) { // only prefix exists
                    text = decodeSubstring(number, text);
                } else {
                    text.append(decodeSubstring(number, textPart));
                }

                textPart = text;
            } else if (Character.isDigit(current)) {
                numberPart.append(current);
                while (Character.isDigit(source.charAt(index + 1))) {
                    numberPart.append(source.charAt(index + 1));
                    index ++;
                }
                textStack.push(textPart);
                textPart = new StringBuilder();
            } else {
                textPart.append(current);
            }
            index ++;
        }

        return textPart.toString();
    }

    private static StringBuilder decodeSubstring(int number, StringBuilder part) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number; i++) {
            result.append(part);
        }
        return result;
    }

}
