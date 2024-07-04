package org.pcs.codingsolutions.util.graph;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Solution for:
 * <p>
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
 * Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
 * <p>
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it,
 * denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 * <p>
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
 * return true if you can visit all the rooms, or false otherwise.
 * <p>
 * Constraints:
 * <p>
 * n == rooms.length
 * 2 <= n <= 1000
 * 0 <= rooms[i].length <= 1000
 * 1 <= sum(rooms[i].length) <= 3000
 * 0 <= rooms[i][j] < n
 * All the values of rooms[i] are unique.
 */
@UtilityClass
public class RoomsVisitingPossibilityDeterminer {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> nonVisitedRoomNumbers = IntStream.range(1, rooms.size()).boxed().collect(Collectors.toSet());

        visitRoom(rooms.get(0), rooms, nonVisitedRoomNumbers);
        return nonVisitedRoomNumbers.isEmpty();
    }

    private void visitRoom(List<Integer> currentRoomKeys,
                           List<List<Integer>> rooms,
                           Set<Integer> nonVisitedRoomNumbers) {
        for (Integer roomNumber : currentRoomKeys) {
            if (nonVisitedRoomNumbers.contains(roomNumber)) {
                nonVisitedRoomNumbers.remove(roomNumber);
                visitRoom(rooms.get(roomNumber), rooms, nonVisitedRoomNumbers);
            }
        }
    }
}
