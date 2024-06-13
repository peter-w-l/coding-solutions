package org.pcs.codingsolutions.util.linkedlist;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.ListNode;

/**
 * Solution for:
 *
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ListItemsSorter {
    public static ListNode sortByOddAndEven(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode oddTail = head;
        ListNode evenHead = head.getNext();
        ListNode evenTail = head.getNext();
        boolean isOdd = true;
        ListNode current = head.getNext().getNext();
        while(current != null) {
             if (isOdd) {
                 oddTail.setNext(current);
                 oddTail = oddTail.getNext();
             } else {
                 evenTail.setNext(current);
                 evenTail = evenTail.getNext();
             }
            current = current.getNext();
            isOdd = !isOdd;
        }
        oddTail.setNext(evenHead);
        evenTail.setNext(null);

        return head;
    }
}
