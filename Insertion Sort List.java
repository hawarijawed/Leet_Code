/*
Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
*/
//--------------------------- Insertion Sort Implementation --------------------------//
class Solution {
    
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode previous = dummy;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (previous.val > current.val) {
                previous = dummy;
            }

            //previous.val < current.val <= previous.next.val
            while (previous.next != null && previous.next.val < current.val) {
                previous = previous.next;
            }
            current.next = previous.next;
            previous.next = current;

            //previous = dummy;
            current = next;
        }
        return dummy.next;
    }
}

//--------------------------- Using Built In Sort ------------------------//
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
