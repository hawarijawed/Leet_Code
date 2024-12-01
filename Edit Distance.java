/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
*/
class Solution {
    
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
    
        // Create a DP table with dimensions (n1+1) x (n2+1)
        int[][] dp = new int[n1 + 1][n2 + 1];
    
        // Initialize the DP table
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                // Base case: If one of the strings is empty, the cost is the length of the other string
                if (i == 0) {
                    dp[i][j] = j;  // All insertions
                } else if (j == 0) {
                    dp[i][j] = i;  // All deletions
                } else {
                    // If characters are equal, no operation is needed, so carry over the value from the diagonal
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // Compute the minimum of insert, delete, and substitute
                        dp[i][j] = 1 + Math.min(dp[i - 1][j],  // Delete
                                Math.min(dp[i][j - 1],  // Insert
                                        dp[i - 1][j - 1]));  // Substitute
                    }
                }
            }
        }
    
        // The answer is in dp[n1][n2]
        return dp[n1][n2];
    }
}
