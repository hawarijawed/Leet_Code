/*
You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].

Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.
*/

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double prob[] = new double[n];

        prob[start_node] = 1;
        
        for(int i=0; i<n-1;i++){
            int j = 0;
            boolean isChanged = false;
            for(int edge[] :edges){
                int u = edge[0];
                int v = edge[1];
                double sp = succProb[j];

                if(prob[u]*sp>prob[v]){
                    prob[v] = prob[u]*sp;
                    isChanged = true;
                }
                if(prob[v]*sp>prob[u]){
                    prob[u] = prob[v]*sp;
                    isChanged = true;
                }

                j++;

            }
            if(!isChanged){
                break;
            }
        }
        return prob[end_node];

    }
}
