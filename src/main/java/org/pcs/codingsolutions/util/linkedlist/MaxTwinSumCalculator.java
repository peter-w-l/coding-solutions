package org.pcs.codingsolutions.util.linkedlist;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.ListNode;

/**
 * Solution for:
 * <p>
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 * <p>
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 * <p>
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MaxTwinSumCalculator {

    public static int pairSum(ListNode head) {
        // 1. use slow-fast approach to find a middle node
        ListNode slow = head; // will be a middle node at the end of while cycle
        ListNode fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        // 2. reverse the list from the middle till the end node
        ListNode reversedListTail = null;
        ListNode current = slow;
        while (current != null) {
            ListNode next = current.getNext();
            current.setNext(reversedListTail);
            reversedListTail = current;
            current = next;
        }

        // 3. iterate over regular and reversed lists and calculate their sums and max
        int max = Integer.MIN_VALUE;
        current = head;
        while (reversedListTail != null) {
            int sum = current.getVal() + reversedListTail.getVal();
            max = Math.max(max, sum);
            current = current.getNext();
            reversedListTail = reversedListTail.getNext();
        }
        return max; // time complexity is O(N). Space complexity is O(1).
    }
}
