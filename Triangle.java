/*
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
*/

class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        for (int i = tri.size() - 2; i >= 0; i--)
            for (int j = 0; j < tri.get(i).size(); j++)
                tri.get(i).set(j, tri.get(i).get(j) + Math.min(
                    tri.get(i + 1).get(j),
                    tri.get(i + 1).get(j + 1)
                ));
        return tri.get(0).get(0);
    }
}
