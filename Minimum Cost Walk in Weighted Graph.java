/*
There is an undirected weighted graph with n vertices labeled from 0 to n - 1.

You are given the integer n and an array edges, where edges[i] = [ui, vi, wi] indicates that there is an edge between vertices ui and vi with a weight of wi.

A walk on a graph is a sequence of vertices and edges. The walk starts and ends with a vertex, and each edge connects the vertex that comes before it and the vertex that comes after it. It's important to note that a walk may visit the same edge or vertex more than once.

The cost of a walk starting at node u and ending at node v is defined as the bitwise AND of the weights of the edges traversed during the walk. In other words, if the sequence of edge weights encountered during the walk is w0, w1, w2, ..., wk, then the cost is calculated as w0 & w1 & w2 & ... & wk, where & denotes the bitwise AND operator.

You are also given a 2D array query, where query[i] = [si, ti]. For each query, you need to find the minimum cost of the walk starting at vertex si and ending at vertex ti. If there exists no such walk, the answer is -1.

Return the array answer, where answer[i] denotes the minimum cost of a walk for query i.
*/
class DSU{
    int rank[];
    int parent[];
    DSU(int n){
        rank = new int[n];
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }

    public int find(int node){
        if(node == parent[node]){
            return node;
        }

        parent[node] = find(parent[node]);
        return parent[node];
    }

    public void union(int node1, int node2){
        int rootParent1 = find(node1);
        int rootParent2 = find(node2);
        if(rootParent1 == rootParent2){
            return;
        }

        if(rank[rootParent1] < rank[rootParent2]){
            parent[rootParent1] = rootParent2;
        }
        else if(rank[rootParent1] > rank[rootParent2]){
            parent[rootParent2] = rootParent1;
        }
        else{
            parent[rootParent2] = rootParent1;
            rank[rootParent1]++;
        }
    }
}
class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU dsu = new DSU(n);
        for(int edge[]: edges){
            dsu.union(edge[0], edge[1]);
        }

        int compCost[] = new int[n];
        Arrays.fill(compCost, Integer.MAX_VALUE);
        for(int edge[]: edges){
            int rootParent = dsu.find(edge[0]);
            compCost[rootParent] = compCost[rootParent] & edge[2];
        }

        int m = query.length;
        int res[] = new int[m];
        for(int i=0; i<m; i++){
            int rootParent1 = dsu.find(query[i][0]);
            int rootParent2 = dsu.find(query[i][1]);
            if(rootParent1 != rootParent2){
                res[i] = -1;
            }
            else{
                res[i] = compCost[rootParent1];
            }
        }

        return res;
    }
}
