/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.
*/
//-------------------------------------- Brute Force Approach: Time-> O(n), Space-> O(n) -----------------------------------//
class Solution {
    public ListNode partition(ListNode head, int x) {
        ArrayList<Integer> lst1 = new ArrayList<>();
        ArrayList<Integer> lst2 = new ArrayList<>();

        ListNode temp = head;
        while(temp != null){
            if(temp.val < x){
                lst1.add(temp.val);
            }
            else{
                lst2.add(temp.val);
            }

            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1);
        temp = dummy;
        for(int i=0; i<lst1.size(); i++){
            temp.next = new ListNode(lst1.get(i));
            temp = temp.next;
        }
        for(int i=0; i<lst2.size(); i++){
            temp.next = new ListNode(lst2.get(i));
            temp = temp.next;
        }
        return dummy.next;  
    }
}
//-------------------------------------- Brute Force Approach: Time-> O(n), Space-> O(1) -----------------------------------//
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode smallHead = small;
        ListNode largeHead = large;
        while(head != null){
            if(head.val < x){
                smallHead.next = new ListNode(head.val);
                smallHead = smallHead.next;
            }
            else{
                largeHead.next = new ListNode(head.val);
                largeHead = largeHead.next;
            }
            head = head.next;
        }
        smallHead.next = large.next;
        return small.next;
    }
}
