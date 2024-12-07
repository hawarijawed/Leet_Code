/*
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
*/
class MyLinkedList {
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
    Node head;
    int size;
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index > size) return -1;
        
        if(index == 0) {
            return head==null?-1:head.val;
        }
        Node curr = head;
        for(int i=0; i<index; i++){
            curr = curr.next;
        }
        if(curr == null) return -1;
        return curr.val;
    }
    
    public void addAtHead(int val) {
        if(head == null){
            head = new Node(val);
            size++;
            return;
        }

        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        size++;
    }
    
    public void addAtTail(int val) {
        if(head == null){
            addAtHead(val);
            return;
        }

        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = new Node(val);
        curr = curr.next;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return; // If the index is out of bounds, do nothing
        }

        // If index == 0, add at head
        if (index == 0) {
            addAtHead(val);
            return;
        }

        // Traverse to the node just before the desired index
        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        // Insert the new node
        Node newNode = new Node(val);
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return; // If index is out of bounds, do nothing
        }

        // If index == 0, delete the head node
        if (index == 0) {
            head = head.next;
        } else {
            // Traverse to the node just before the node to be deleted
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            // Delete the node by skipping it
            curr.next = curr.next.next;
        }

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
