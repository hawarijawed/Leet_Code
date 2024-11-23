/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int sum =0, carry = 0;
        while(temp1 != null || temp2 != null || carry != 0){
            sum = carry;

            if(temp1 != null){
                sum += temp1.val;
                temp1 = temp1.next;
            }

            if(temp2 != null){
                sum += temp2.val;
                temp2 = temp2.next;
            }

            carry = sum /10;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
        }

        return dummy.next;
    }
}
