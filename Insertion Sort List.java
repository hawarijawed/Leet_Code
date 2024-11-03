/*
Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
*/
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ArrayList<Integer> lst = new ArrayList<>();
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode temp = head;
        while(temp != null){
            lst.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(lst);

        ListNode dummy = new ListNode(0);
        temp = dummy;
        for(int i=0; i<lst.size(); i++){
            temp.next = new ListNode(lst.get(i));
            temp = temp.next;
        }

        return dummy.next;
    }
}
