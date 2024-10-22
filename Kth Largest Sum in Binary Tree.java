/*
You are given the root of a binary tree and a positive integer k.

The level sum in the tree is the sum of the values of the nodes that are on the same level.

Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.

Note that two nodes are on the same level if they have the same distance from the root.
*/
class Solution {
    
    public long kthLargestLevelSum(TreeNode root, int k) {
        ArrayList<Long> lst = new ArrayList<>();
        levelOrderTraversalSums(root, lst);
        
        // Sort the list in descending order
        Collections.sort(lst, Collections.reverseOrder());
        
        int size = lst.size();
        // Check if k is valid
        if (k > size || k <= 0) {
            return -1;
        }

        return lst.get(k - 1); // Return the k-th largest sum
    }

    public void levelOrderTraversalSums(TreeNode root, ArrayList<Long> lst) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            long levelSum = 0; // Initialize sum for the current level
            int levelSize = queue.size(); // Number of nodes at the current level

            for (int i = 0; i < levelSize; i++) {
                // Get the current node from the queue
                TreeNode node = queue.poll();
                levelSum += node.val; // Add the node's value to the level sum

                // Add left child to queue
                if (node.left != null) {
                    queue.add(node.left);
                }

                // Add right child to queue
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // Add the level sum to the list
            lst.add(levelSum);
        }
    }
}
