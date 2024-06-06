package org.pcs.codingsolutions.util.stack;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;
import java.util.Deque;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AsteroidsStateCalculator {
    public static int[] getAsteroidsStatesAfterCollisions(int[] asteroidsSizeAndDirections) {
        Deque<Integer> output = new ArrayDeque<>();

        int inputIndex = 0;
        while (inputIndex < asteroidsSizeAndDirections.length) {
            if (output.isEmpty()) {
                output.push(asteroidsSizeAndDirections[inputIndex]); // push to stack
                inputIndex++;
                continue;
            }
            int leftAsteroidSizeAndDirection = output.peek();
            int rightAsteroidSizeAndDirection = asteroidsSizeAndDirections[inputIndex];

            boolean areMovingTowardsEachOther = leftAsteroidSizeAndDirection > 0 && rightAsteroidSizeAndDirection < 0;
            if (!areMovingTowardsEachOther) {
                output.push(rightAsteroidSizeAndDirection); // push to stack
                inputIndex++;
                continue;
            }
            int sum = leftAsteroidSizeAndDirection + rightAsteroidSizeAndDirection;
            if (sum == 0) {
                output.pop();  // pop from stack
                inputIndex++; // right is destroyed as well
            } else if (Math.abs(rightAsteroidSizeAndDirection) > Math.abs(leftAsteroidSizeAndDirection)) {
                output.pop();  // pop from stack
            } else {
                inputIndex++; // right is destroyed
            }
        }

        int outputSize = output.size();
        int[] result = new int[outputSize];
        while(!output.isEmpty()) {
            result[outputSize -1] = output.pop();
            outputSize --;
        }
        return result;
    }
}
