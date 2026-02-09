/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int []arr, int st, int en){
        if(st > en) return null;

        int mid = st + (en - st)/2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(arr, st, mid - 1);
        root.right = helper(arr, mid + 1, en);
        return root;
    }
}
