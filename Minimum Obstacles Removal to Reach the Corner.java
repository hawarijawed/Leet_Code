/*
You are given a 0-indexed 2D integer array grid of size m x n. Each cell has one of two values:
0 represents an empty cell,
1 represents an obstacle that may be removed.
You can move up, down, left, or right from and to an empty cell.

Return the minimum number of obstacles to remove so you can move from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1).
*/
class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        for (int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);
        Deque<int[]> dq = new ArrayDeque<>();

        distance[0][0] = 0;
        dq.offerFirst(new int[] {0, 0});
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!dq.isEmpty()) {
            int[] cell = dq.pollFirst();
            int x = cell[0], y = cell[1];
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newDist = distance[x][y] + grid[nx][ny];
                    if (newDist < distance[nx][ny]) {
                        distance[nx][ny] = newDist;
                        if (grid[nx][ny] == 0) {
                            dq.offerFirst(new int[] {nx, ny});
                        } else {
                            dq.offerLast(new int[] {nx, ny});
                        }
                    }
                }
            }
        }
        return distance[m-1][n-1];
    }
}
