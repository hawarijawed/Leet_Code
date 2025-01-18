/*
Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:

1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
Notice that there could be some signs on the cells of the grid that point outside the grid.

You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path does not have to be the shortest.

You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

Return the minimum cost to make the grid have at least one valid path.
*/
class Solution {

    // Direction vectors: right, left, down, up (matching grid values 1,2,3,4)
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minCost(int[][] grid) {
        int numRows = grid.length, numCols = grid[0].length;

        // Min-heap ordered by cost. Each element is [cost, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, 0, 0 });

        // Track minimum cost to reach each cell
        int[][] minCost = new int[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            Arrays.fill(minCost[row], Integer.MAX_VALUE);
        }
        minCost[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], row = curr[1], col = curr[2];

            // Skip if we've found a better path to this cell
            if (minCost[row][col] != cost) continue;

            // Try all four directions
            for (int dir = 0; dir < 4; dir++) {
                int newRow = row + dirs[dir][0];
                int newCol = col + dirs[dir][1];

                // Check if new position is valid
                if (
                    newRow >= 0 &&
                    newRow < numRows &&
                    newCol >= 0 &&
                    newCol < numCols
                ) {
                    // Add cost=1 if we need to change direction
                    int newCost = cost + (dir != (grid[row][col] - 1) ? 1 : 0);

                    // Update if we found a better path
                    if (minCost[newRow][newCol] > newCost) {
                        minCost[newRow][newCol] = newCost;
                        pq.offer(new int[] { newCost, newRow, newCol });
                    }
                }
            }
        }

        return minCost[numRows - 1][numCols - 1];
    }
}
