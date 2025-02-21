/*
Given a binary tree with the following rules:

root.val == 0
For any treeNode:
If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

Implement the FindElements class:

FindElements(TreeNode* root) Initializes the object with a contaminated binary tree and recovers it.
bool find(int target) Returns true if the target value exists in the recovered binary tree.
*/
class FindElements {

    HashSet<Integer> seen;

    public FindElements(TreeNode root) {
        seen = new HashSet<>();
        bfs(root);
    }

    public boolean find(int target) {
        return seen.contains(target);
    }

    private void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            // visit currentNode by adding its recovered value to the set
            seen.add(currentNode.val);
            if (currentNode.left != null) {
                currentNode.left.val = currentNode.val * 2 + 1;
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                currentNode.right.val = currentNode.val * 2 + 2;
                queue.add(currentNode.right);
            }
        }
    }
}
