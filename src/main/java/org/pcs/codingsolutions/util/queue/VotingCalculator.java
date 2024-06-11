package org.pcs.codingsolutions.util.queue;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution for:
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class VotingCalculator {
    public static String predictPartyVictory(String participants) {
        if (participants.length() == 1) {
            return participants.charAt(0) == 'R' ? "Radiant" : "Dire";
        }

        Queue<Integer> radiants = new LinkedList<>();
        Queue<Integer> dires = new LinkedList<>();

        char[] participantsArray = participants.toCharArray();
        int participantsNumber = participantsArray.length;
        for (int i = 0; i < participantsNumber; i++) {
            if (participantsArray[i] == 'R') {
                radiants.add(i);
            } else {
                dires.add(i);
            }
        }

        while (!radiants.isEmpty() && !dires.isEmpty()) {
            if (radiants.element() < dires.element()) {
                radiants.add(radiants.peek() + participantsNumber); // radiant goes to the next round
            } else {
                dires.add(dires.peek() + participantsNumber); // dire goes to the next round
            }
            radiants.poll();
            dires.poll();
        }
        return dires.isEmpty() ? "Radiant" : "Dire";
    }
}
