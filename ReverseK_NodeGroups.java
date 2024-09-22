/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
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
    ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head;
        ListNode prev = null;
        ListNode next = head;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        temp = head;
        int hd = count / k;
        count = 0;
        int innercount = 1;
        ListNode start = head;
        ListNode prev = null;
        ListNode ns = head;
        while (count < hd) {
            start = ns;
            while (innercount != k && temp != null) {
                temp = temp.next;
                innercount++;
            }
            innercount = 1;
            ns = temp.next;
            temp.next = null;
            temp = ns;
            if (prev == null) {
                head = reverse(start);
                prev = start;
            } else {
                prev.next = reverse(start);
                prev = start;
            }
            count++;
        }
        prev.next = temp;
        return head;
    }
}
