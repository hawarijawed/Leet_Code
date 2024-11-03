/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 
*/
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return; // No need to reorder if the list is empty or has one node
        }

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next; // Store the next node
            curr.next = prev; // Reverse the current node's pointer
            prev = curr; // Move prev to the current node
            curr = nextTemp; // Move to the next node
        }

        // Step 3: Merge the two halves
        ListNode first = head;
        ListNode second = prev; // The head of the reversed second half
        while (second.next != null) {
            ListNode temp1 = first.next; // Store the next node of first
            ListNode temp2 = second.next; // Store the next node of second

            first.next = second; // Link the first half node to the second half node
            second.next = temp1; // Link the second half node to the next node in the first half

            first = temp1; // Move to the next node in the first half
            second = temp2; // Move to the next node in the second half
        }
    }
}
