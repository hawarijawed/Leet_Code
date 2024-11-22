/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        if(left == right) return head;
        ListNode temp = head;
        int count = 1;
        ListNode prev = null;
        while(count < left){
            prev = temp;
            temp = temp.next;
            count++;
        }

        ListNode conn = prev;
        ListNode tail = temp;
        ListNode curr = temp;
        while(count<= right){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            count++;
        }
        
        if(conn != null){
            conn.next  = prev;
        }
        else{
            head = prev;
        }
        tail.next = curr;
        return head;
    }
}
