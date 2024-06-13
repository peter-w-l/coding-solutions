package org.pcs.codingsolutions.util.linkedlist;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.ListNode;

/**
 * Solution for:
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem
 * without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LinkedListPairNodesSwapProcessor {
    public static ListNode swapPairs(ListNode firstNode) {
        if (firstNode == null || firstNode.getNext() == null) {
            return firstNode;
        }

        ListNode secondNode = firstNode.getNext();
        ListNode nextPairNode = secondNode.getNext();

        secondNode.setNext(firstNode);
        firstNode.setNext(swapPairs(nextPairNode));

        return secondNode;
    }
}
