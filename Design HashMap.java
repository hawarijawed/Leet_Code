/*
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
*/
//----------------- Design HashMap-> Method 01: Using Array ---------------//
class MyHashMap {
    int[] map;
    public MyHashMap() {
        map = new int[1000001];
    }
    
    public void put(int key, int value) {
        map[key] = value+1;
    }
    
    public int get(int key) {
        return map[key]-1;
    }
    
    public void remove(int key) {
        map[key] = 0;
    }
}

//---------------- Design HashMap-> Method 02: Actual Implementation ----------------//
class MyHashMap {
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    int SIZE = 1000001;
    Node [] map;
    public MyHashMap() {
        map = new Node[SIZE];
    }
    
    public int hash(int key){
        return key%SIZE;
    }
    public void put(int key, int value) {
        int pos = hash(key);
        //Check if map[pos] is null or not
        if(map[pos] == null){
            map[pos] = new Node(key, value);
            return;
        }
        // Get the node at pos in map and traverse it
        Node curr = map[pos];
        while(curr != null){
            //If same key is already present in map
            //Then update the value
            if(key == curr.key){
                curr.value = value;
                return;
            }

            if(curr.next == null){
                //Pointer is pointing to last node
                break;
            }
            curr = curr.next;
        }

        curr.next = new Node(key, value);
    }
    
    public int get(int key) {
        //Get the map index
        int pos = hash(key);

        //Check if map[pos] contains any node or not
        if(map[pos] == null)
        {
            return -1;
        }

        Node curr = map[pos];
        //Traverse the curr node until key match is found
        while(curr != null){
            if(curr.key == key){
                return curr.value;
            }

            curr = curr.next;
        }
        
        //Key is not present in the list
        return -1;
    }
    
    public void remove(int key) {
        //Get the position in map first
        int pos = hash(key);
        
        //Check if map[pos] contains node or not
        if(map[pos] == null) return;

        //Get the node present at map[pos] to traverse it and delete required node
        Node curr = map[pos];
        //Head deletion
        if(curr.key == key){
            map[pos] = curr.next;
            return;
        }
        boolean isFound = false;
        Node prev = null;
        while(curr.next != null){
            
            if(curr.next.key == key ){
                if(curr.next.next != null){
                    curr.next = curr.next.next;
                }
                else{
                    curr = null;
                    break;
                }
            }
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
