/*
In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
*/
class Solution {

    // Performs DFS and returns true if there's a path between src and target.
    private boolean isConnected(
        int src,
        int target,
        boolean[] visited,
        List<Integer>[] adjList
    ) {
        visited[src] = true;

        if (src == target) {
            return true;
        }

        boolean isFound = false;
        for (int adj : adjList[src]) {
            if (!visited[adj]) {
                isFound = isFound || isConnected(adj, target, visited, adjList);
            }
        }

        return isFound;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;

        List<Integer>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            boolean[] visited = new boolean[N];

            // If DFS returns true, we will return the edge.
            if (isConnected(edge[0] - 1, edge[1] - 1, visited, adjList)) {
                return new int[] { edge[0], edge[1] };
            }

            adjList[edge[0] - 1].add(edge[1] - 1);
            adjList[edge[1] - 1].add(edge[0] - 1);
        }

        return new int[] {};
    }
}
