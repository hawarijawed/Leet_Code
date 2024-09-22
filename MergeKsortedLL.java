/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
*/
//----------------------- Naive Approach ---------------------//
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=0; i<lists.length; i++){
            ListNode node = lists[i];
            ListNode temp = node;
            while(temp != null){
                lst.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(lst);
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for(int i=0; i<lst.size(); i++){
            ListNode n2 = new ListNode(lst.get(i));
            temp.next = n2;
            temp = n2;
        }

        return dummy.next;
    }
}

//----------------------- Better Approach ---------------------//
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the head of each list to the min-heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        
        // Create a dummy node to simplify the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // While there are nodes in the heap
        while (!minHeap.isEmpty()) {
            // Extract the smallest node
            ListNode smallestNode = minHeap.poll();
            current.next = smallestNode; // Append it to the result list
            current = current.next; // Move the current pointer
            
            // If there's a next node in the extracted list, add it to the heap
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }
        
        return dummy.next; // Return the merged list, skipping the dummy node
    }
}
