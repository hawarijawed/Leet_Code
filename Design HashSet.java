/*
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
*/
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyHashSet {
    // Inner linked list class
    class MyLinkedList {
        Node head;

        public MyLinkedList() {
            head = null;
        }
    }

    // HashSet is backed by a linked list.
    MyLinkedList[] listArray;
    int size;

    public MyHashSet() {
        size = 1000; // Choose an arbitrary size for the hash set
        listArray = new MyLinkedList[size];
        for (int i = 0; i < size; i++) {
            listArray[i] = new MyLinkedList(); // Initialize all lists
        }
    }

    // Hash function to determine the index for the given key
    private int getIndex(int key) {
        return key % size;
    }

    // Add a key to the set
    public void add(int key) {
        int index = getIndex(key);
        Node currentNode = listArray[index].head;

        // Check if the key is already present, if yes, do nothing
        while (currentNode != null) {
            if (currentNode.data == key) {
                return; // The key is already present, do nothing
            }
            currentNode = currentNode.next;
        }

        // If key is not found, add it to the linked list at the determined index
        Node newNode = new Node(key);
        newNode.next = listArray[index].head;
        listArray[index].head = newNode;
    }

    // Remove a key from the set
    public void remove(int key) {
        int index = getIndex(key);
        Node currentNode = listArray[index].head;
        Node prevNode = null;

        while (currentNode != null) {
            if (currentNode.data == key) {
                if (prevNode == null) {
                    // If it's the first node
                    listArray[index].head = currentNode.next;
                } else {
                    // Remove the current node
                    prevNode.next = currentNode.next;
                }
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    // Check if the key exists in the set
    public boolean contains(int key) {
        int index = getIndex(key);
        Node currentNode = listArray[index].head;

        while (currentNode != null) {
            if (currentNode.data == key) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
