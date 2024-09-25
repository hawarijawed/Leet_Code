class Solution {
    
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

    // Find the middle of the linked list
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Reverse the second half of the linked list
    ListNode prev = null;
    while (slow != null) {
        ListNode nextTemp = slow.next;
        slow.next = prev;
        prev = slow;
        slow = nextTemp;
    }

    // Compare the first half and the reversed second half
    ListNode left = head;
    ListNode right = prev; // start of the reversed second half
    while (right != null) {
        if (left.val != right.val) {
            return false;
        }
        left = left.next;
        right = right.next;
    }

    return true;
    }
}
