/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
*/
//----------------------------- Brute Force: O(n), Space: O(n) -----------------------------------//
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        while(temp != null){
            set.add(temp.val);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1);
        temp = dummy;
        for(int elem: set){
            temp.next = new ListNode(elem);
            temp = temp.next;
        }

        return dummy.next;
    }
}

//------------------------------------ Optimal Approach: Time:O(n), Space: (1) -------------------------------------//
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
        if(head==null){
            return head;
        }
        while(temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
            }
            else{
                temp=temp.next;
            }
        }
        return head;
    }
}
