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
        HashSet<Integer> set = new HashSet<>();
        for (int val : nums) {
            set.add(val);
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (head != null) {
            if (!set.contains(head.val)) {
                // Keep this node
                prev.next = head;
                prev = prev.next;
            }
            // Otherwise skip it
            head = head.next;
        }

        // Important: terminate the list properly
        prev.next = null;

        return dummy.next;
    }
}
