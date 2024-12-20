/*
Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.

For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
Return the root of the reversed tree.

A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.

The level of a node is the number of edges along the path between it and the root node
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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();

            ArrayList<TreeNode> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(level%2 !=0){
                    list.add(node);
                }
            }

            if(level%2!=0){
                int r = 0;
                int l = list.size()-1;
                while(r<l){
                    int temp = list.get(r).val;
                    list.get(r).val = list.get(l).val;
                    list.get(l).val = temp;
                    r++;
                    l--;
                }
            }
            level++;
        }

        return root;
    }
}
