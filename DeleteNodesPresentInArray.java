/*
You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.
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
   
    public ListNode modifiedList(int[] nums, ListNode head) {
        
        //Form a table of size 1e5
        boolean set[] = new boolean[(int)1e5+1];
        for(int a: nums){
            set[a] = true;
        } 

        ListNode prev = null;
        ListNode temp = head;

        while(temp != null){
            //If node to be deleted found
            if(set[temp.val] == true){
                // For deleting head of LL
                if(prev == null){
                    head = head.next;
                    temp.next = null;
                    temp = head;
                }
                else{
                    //target node being other than head node
                    prev.next = temp.next;
                    temp.next = null;
                    temp = prev.next;
                }
            }
            else{
                prev = temp;
                temp = temp.next;
            }
        }

        return head;
    }
}
