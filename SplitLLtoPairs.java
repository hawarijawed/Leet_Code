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
/*
Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        //Calculate the size of the LL
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        //Number of nodes per split
        int split_size = size/k;
        int extra = size%k;
        ListNode []res = new ListNode[k];
        temp = head;
        for(int i=0; i<k; i++){
            if(temp == null) break;
            ListNode currHead = temp;
            ListNode prev = null;
            int len = 0;
            while(temp != null && len < split_size){
                prev = temp;
                temp = temp.next;
                len++;
            }

            if(extra > 0){
                prev = temp;
                temp = temp.next;
                extra--;
            }
            prev.next = null;
            res[i] = currHead;
        }

        return res;
    }
}
