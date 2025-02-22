/*
We run a preorder depth-first search (DFS) on the root of a binary tree.

At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.  The depth of the root node is 0.

If a node has only one child, that child is guaranteed to be the left child.

Given the output traversal of this traversal, recover the tree and return its root.
*/
class Solution {
    int index = 0;
    int n = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        return helper(traversal, 0);
    }

    public TreeNode helper(String traversal, int depth){
        if(index >= n) return null;

        int count = 0;
        int tempI = index;
        while(tempI <n && !Character.isDigit(traversal.charAt(tempI))){
            count++;
            tempI++;
        }

        if(count != depth) return null;
        index = tempI;

        int val = 0;
        while(index < n && Character.isDigit(traversal.charAt(index))){
            val = val*10 + (traversal.charAt(index) - '0');
            index++;
        }

        TreeNode node = new TreeNode(val);
        node.left = helper(traversal, depth+1);
        node.right = helper(traversal, depth + 1);
        return node;

    }
}
