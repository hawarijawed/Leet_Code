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
    public ListNode swapPairs(ListNode head) {
        //Handling edge cases 
        //if there is no data node
        ListNode first = head;
        ListNode prev = null;
        while(first != null && first.next != null){
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            //first pairwise swap of head node
            if(prev == null){
                head = second;
            }
            else{
                prev.next = second;
            }
            prev = first;
            first = first.next;
        }
        return head;
    }
}
