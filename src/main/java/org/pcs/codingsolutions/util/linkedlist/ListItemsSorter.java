package org.pcs.codingsolutions.util.linkedlist;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcs.codingsolutions.model.ListNode;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ListItemsSorter {
    /**
     * Solution for:
     *
     * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
     * The first node is considered odd, and the second node is even, and so on.
     * Note that the relative order inside both the even and odd groups should remain as it was in the input.
     * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
     */
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

    /**
     * Solution for:
     *
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     * @param head head of linked list
     * @return head of reversed list
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode current = head;
        ListNode reversedHead = null;
        while (current != null) {
            ListNode next = current.getNext();

            current.setNext(reversedHead);
            reversedHead = current;

            current = next;
        }

        return reversedHead;
    }
}
