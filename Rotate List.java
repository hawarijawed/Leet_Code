/*
Given the head of a linked list, rotate the list to the right by k places.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head; // No rotation needed for empty or single node list
        }

        // Calculate the size of the linked list
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Use modulo to handle cases where k >= size
        k = k % size;
        if (k == 0) {
            return head; // No rotation needed if k is 0 or a multiple of size
        }

        // Find the new tail, which is at position (size - k - 1)
        int newTailIndex = size - k - 1;
        temp = head;
        for (int i = 0; i < newTailIndex; i++) {
            temp = temp.next;
        }

        // The new head is the next node after the new tail
        ListNode newHead = temp.next;
        temp.next = null; // Break the link

        // Find the last node of the new rotated list
        ListNode lastNode = newHead;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
    
        // Connect the last node to the old head
        lastNode.next = head;

        return newHead;
        
    }
}
