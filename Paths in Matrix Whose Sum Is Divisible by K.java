/*
You are given a 0-indexed m x n integer matrix grid and an integer k. You are currently at position (0, 0) and you want to reach position (m - 1, n - 1) moving only down or right.

Return the number of paths where the sum of the elements on the path is divisible by k. Since the answer may be very large, return it modulo 109 + 7.
*/
class Solution {

    private static final int MOD = 1000000007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        long[][][] dp = new long[m + 1][n + 1][k];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j][grid[0][0] % k] = 1;
                    continue;
                }

                int value = grid[i - 1][j - 1] % k;
                for (int r = 0; r < k; r++) {
                    int prevMod = (r - value + k) % k;
                    dp[i][j][r] =
                        (dp[i - 1][j][prevMod] + dp[i][j - 1][prevMod]) % MOD;
                }
            }
        }

        return (int) dp[m][n][0];
    }
}
