/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node curr = root;
        if(root == null) return root;
        Node nxt = (root.left != null)?root.left:null;

        while(curr != null && nxt != null){
            curr.left.next = curr.right;
            if(curr.next != null){
                curr.right.next = curr.next.left;
            }
            curr = curr.next;
            if(curr == null){
                curr = nxt;
                nxt = curr.left;
            }
        }
        return root;
    }
}
