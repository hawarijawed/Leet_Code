/*
Given the head of a linked list head, in which each node contains an integer value.

Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.

Return the linked list after insertion.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 */
class Solution {
    public int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        //If there is only one element in list or empty list
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null){
            int a = slow.val;
            int b = fast.val;
            int c = gcd(a, b);
            ListNode temp = new ListNode(c);
            slow.next = temp;
            temp.next = fast;
            slow = fast;
            fast = fast.next;
        }

        return head;
    }
}
