package org.pcs.codingsolutions.util.linkedlist;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.ListNode;

/**
 * Solution for:
 *
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LinkedListMiddleCalculator {
    public static ListNode getMiddleNode(ListNode head) {
        if (head.getNext() == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow; // time complexity is O(N). Space complexity is O(1).
    }
}
