package org.pcs.codingsolutions.util.twopointers;

import lombok.experimental.UtilityClass;
import org.pcs.codingsolutions.model.ListNode;


/**
 * Solution for:
 * <p>
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
@UtilityClass
public class SortedArraysMerger {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode root = new ListNode();
        ListNode iterableListNode = root;
        while (list1 != null && list2 != null) {
            ListNode listNode;
            if (list1.getVal() <= list2.getVal()) {
                listNode = ListNode.builder()
                        .val(list1.getVal())
                        .build();
                list1 = list1.getNext();
            } else {
                listNode = ListNode.builder()
                        .val(list2.getVal())
                        .build();
                list2 = list2.getNext();
            }
            iterableListNode.setNext(listNode);
            iterableListNode = listNode;
        }
        ListNode nonEmptyList = list1 == null ? list2 : list1;
        while(nonEmptyList != null) {
            ListNode listNode = ListNode.builder()
                    .val(nonEmptyList.getVal())
                    .build();
            nonEmptyList = nonEmptyList.getNext();
            iterableListNode.setNext(listNode);
            iterableListNode = listNode;
        }

        return root.getNext();
    }
}
