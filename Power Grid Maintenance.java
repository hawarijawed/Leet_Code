/*
You are given an integer c representing c power stations, each with a unique identifier id from 1 to c (1‑based indexing).

These stations are interconnected via n bidirectional cables, represented by a 2D array connections, where each element connections[i] = [ui, vi] indicates a connection between station ui and station vi. Stations that are directly or indirectly connected form a power grid.

Initially, all stations are online (operational).

You are also given a 2D array queries, where each query is one of the following two types:

[1, x]: A maintenance check is requested for station x. If station x is online, it resolves the check by itself. If station x is offline, the check is resolved by the operational station with the smallest id in the same power grid as x. If no operational station exists in that grid, return -1.

[2, x]: Station x goes offline (i.e., it becomes non-operational).

Return an array of integers representing the results of each query of type [1, x] in the order they appear.

Note: The power grid preserves its structure; an offline (non‑operational) node remains part of its grid and taking it offline does not alter connectivity.
*/
class Solution {
    int[] parent;

    int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) parent[pb] = pa;
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c + 1];
        for (int i = 1; i <= c; i++) parent[i] = i;

        // Build components
        for (int[] edge : connections) union(edge[0], edge[1]);

        // Initialize online sets per component
        Map<Integer, TreeSet<Integer>> compOnline = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int comp = find(i);
            compOnline.putIfAbsent(comp, new TreeSet<>());
            compOnline.get(comp).add(i);
        }

        List<Integer> res = new ArrayList<>();
        Set<Integer> offline = new HashSet<>();

        for (int[] q : queries) {
            int type = q[0], x = q[1];
            int comp = find(x);

            if (type == 1) {
                if (!offline.contains(x)) {
                    res.add(x);
                } else {
                    TreeSet<Integer> set = compOnline.get(comp);
                    if (set.isEmpty()) res.add(-1);
                    else res.add(set.first());
                }
            } else { // type == 2
                offline.add(x);
                compOnline.get(comp).remove(x);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
