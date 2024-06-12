package org.pcs.codingsolutions.util.linkedlist;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.ListNode;

/**
 * Solution for:
 * <p>
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋
 * denotes the largest integer less than or equal to x.
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MiddleNodeRemover {
    public static ListNode deleteMiddleNode(ListNode head) {
        if (head.getNext() == null) {
            return null;
        }
        int nodesSize = 0;
        ListNode current = head;
        while (current != null) {
            current = current.getNext();
            nodesSize++;
        }

        int middleIndex = Math.floorDiv(nodesSize, 2);

        int index = 0;
        current = head;
        while (index != middleIndex - 1) {
            current = current.getNext();
            index++;
        }
        current.setNext(current.getNext().getNext()); // node[middle - 1].next = node[middle + 1]
        return head;
    }
}
