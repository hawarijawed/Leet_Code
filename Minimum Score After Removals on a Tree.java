/*
There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given a 0-indexed integer array nums of length n where nums[i] represents the value of the ith node. You are also given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

Remove two distinct edges of the tree to form three connected components. For a pair of removed edges, the following steps are defined:

Get the XOR of all the values of the nodes for each of the three components respectively.
The difference between the largest XOR value and the smallest XOR value is the score of the pair.
For example, say the three components have the node values: [4,5,7], [1,9], and [3,3,3]. The three XOR values are 4 ^ 5 ^ 7 = 6, 1 ^ 9 = 8, and 3 ^ 3 ^ 3 = 3. The largest XOR value is 8 and the smallest XOR value is 3. The score is then 8 - 3 = 5.
Return the minimum score of any possible pair of edge removals on the given tree.
*/
class Solution {

    int res = Integer.MAX_VALUE;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> e = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            e.add(new ArrayList<>());
        }
        for (int[] v : edges) {
            e.get(v[0]).add(v[1]);
            e.get(v[1]).add(v[0]);
        }

        int sum = 0;
        for (int x : nums) {
            sum ^= x;
        }

        dfs(0, -1, nums, e, sum);
        return res;
    }

    private int calc(int part1, int part2, int part3) {
        return (
            Math.max(part1, Math.max(part2, part3)) -
            Math.min(part1, Math.min(part2, part3))
        );
    }

    private int dfs(int x, int f, int[] nums, List<List<Integer>> e, int sum) {
        int son = nums[x];
        for (int y : e.get(x)) {
            if (y == f) {
                continue;
            }
            son ^= dfs(y, x, nums, e, sum);
        }

        for (int y : e.get(x)) {
            if (y == f) {
                dfs2(y, x, son, x, nums, e, sum);
            }
        }
        return son;
    }

    private int dfs2(
        int x,
        int f,
        int oth,
        int anc,
        int[] nums,
        List<List<Integer>> e,
        int sum
    ) {
        int son = nums[x];
        for (int y : e.get(x)) {
            if (y == f) {
                continue;
            }
            son ^= dfs2(y, x, oth, anc, nums, e, sum);
        }
        if (f == anc) {
            return son;
        }
        res = Math.min(res, calc(oth, son, sum ^ oth ^ son));
        return son;
    }
}
