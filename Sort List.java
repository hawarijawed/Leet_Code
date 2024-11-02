/*
Given the head of a linked list, return the list after sorting it in ascending order.
*/
//------------------------------- Brute Force Approach -------------------------//
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ArrayList<Integer> lst = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            lst.add(temp.val);
            temp = temp.next;
        }
        
        Collections.sort(lst);
        ListNode dummy = new ListNode(-1);
        temp = dummy;
        for(int i=0; i<lst.size(); i++){
            temp.next = new ListNode(lst.get(i));
            temp = temp.next;
        }

        return dummy.next;
    }
}
