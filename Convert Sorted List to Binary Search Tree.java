/*
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a 
height-balanced binary search tree.
*/
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Finding the middle element
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Create the root node with the middle element
        TreeNode root = new TreeNode(slow.val);

        // Disconnect the left part of the list
        fast = slow.next;
        if (prev != null) {
            prev.next = null;
        }

        // Recursively build left and right subtrees
        root.left = sortedListToBST(head);   // Left subtree
        root.right = sortedListToBST(fast);  // Right subtree

        return root;
    }
}
