/*
You are given an m x n integer matrix grid and an array queries of size k.

Find an array answer of size k such that for each integer queries[i] you start in the top left cell of the matrix and repeat the following process:

If queries[i] is strictly greater than the value of the current cell that you are in, then you get one point if it is your first time visiting this cell, and you can move to any adjacent cell in all 4 directions: up, down, left, and right.
Otherwise, you do not get any points, and you end this process.
After the process, answer[i] is the maximum number of points you can get. Note that for each query you are allowed to visit the same cell multiple times.

Return the resulting array answer.
*/
class Solution {

    public int[] maxPoints(int[][] grid, int[] queries) {
        int rowCount = grid.length, colCount = grid[0].length;
        int[] result = new int[queries.length];
        // Directions for movement (right, down, left, up)
        int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // Store queries along with their original indices to restore order
        // later
        int[][] sortedQueries = new int[queries.length][2];
        for (int index = 0; index < queries.length; index++) {
            sortedQueries[index][0] = queries[index];
            sortedQueries[index][1] = index;
        }
        // Sort queries by value in ascending order
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);

        // Min-heap (priority queue) to process cells in increasing order of
        // value
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        boolean[][] visited = new boolean[rowCount][colCount];
        // Keeps track of the number of cells processed
        int totalPoints = 0;
        // Start from the top-left cell
        minHeap.add(new int[] { grid[0][0], 0, 0 });
        visited[0][0] = true;

        // Process queries in sorted order
        for (int[] query : sortedQueries) {
            int queryValue = query[0], queryIndex = query[1];
            // Expand the cells that are smaller than the current query value
            while (!minHeap.isEmpty() && minHeap.peek()[0] < queryValue) {
                int[] top = minHeap.poll();
                int cellValue = top[0], currentRow = top[1], currentCol =
                    top[2];
                // Increment count of valid cells
                totalPoints++;

                // Explore all four possible directions
                for (int[] dir : DIRECTIONS) {
                    int newRow = currentRow + dir[0], newCol =
                        currentCol + dir[1];

                    // Check if the new cell is within bounds and not visited
                    if (
                        newRow >= 0 &&
                        newCol >= 0 &&
                        newRow < rowCount &&
                        newCol < colCount &&
                        !visited[newRow][newCol]
                    ) {
                        minHeap.add(
                            new int[] { grid[newRow][newCol], newRow, newCol }
                        );
                        // Mark as visited
                        visited[newRow][newCol] = true;
                    }
                }
            }
            // Store the result for this query
            result[queryIndex] = totalPoints;
        }
        return result;
    }
}
