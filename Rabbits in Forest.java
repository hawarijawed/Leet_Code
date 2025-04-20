/*
There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.

Given the array answers, return the minimum number of rabbits that could be in the forest.
*/
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i : answers) mpp.put(i, mpp.getOrDefault(i, 0) + 1);

        int total = 0;
        for (Map.Entry<Integer, Integer> p : mpp.entrySet())
            total += Math.ceil((double)p.getValue() / (p.getKey() + 1)) * (p.getKey() + 1);

        return total;
    }
}
