/*
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
        return null;
    }

    ListNode pointerA = headA;
    ListNode pointerB = headB;

    // Traverse both lists
    while (pointerA != pointerB) {
        // Move to the next node or to the head of the other list
        pointerA = (pointerA == null) ? headB : pointerA.next;
        pointerB = (pointerB == null) ? headA : pointerB.next;
    }

    // Either both pointers are null (no intersection) or they meet at the intersection
    return pointerA;
    }
}
