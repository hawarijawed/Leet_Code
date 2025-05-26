/*
There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.

You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.

A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.

Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.
*/
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        // Build graph and indegree array
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // Queue for Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        // Color count table: [node][color] = max count of that color to that node
        int[][] colorCount = new int[n][26];
        int visited = 0, maxColorValue = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            // Current node's color index
            int colorIdx = colors.charAt(node) - 'a';
            colorCount[node][colorIdx]++;
            maxColorValue = Math.max(maxColorValue, colorCount[node][colorIdx]);

            // Traverse neighbors
            for (int neighbor : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    // Update the neighbor's color count
                    colorCount[neighbor][c] = Math.max(colorCount[neighbor][c], colorCount[node][c]);
                }

                // Decrease indegree and add to queue if it's now zero
                if (--indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If not all nodes were visited, there is a cycle
        return visited == n ? maxColorValue : -1;
    }
}
