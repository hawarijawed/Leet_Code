/*
Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> lst = new ArrayList<>();
        inorder(root, lst);

        return treeFromList(lst, 0, lst.size()-1);
    }

    public void inorder(TreeNode root, ArrayList<Integer> lst){
        if(root == null){
            return;
        }
        
        inorder(root.left, lst);
        lst.add(root.val);
        inorder(root.right, lst);
    }

    public TreeNode treeFromList(ArrayList<Integer> lst, int st, int en){
        if(st > en) return null;
        
        int mid = st + (en - st)/2;
        TreeNode root = new TreeNode(lst.get(mid));

        root.left = treeFromList(lst, st, mid-1);
        root.right = treeFromList(lst, mid+1, en);

        return root;
    }
}
