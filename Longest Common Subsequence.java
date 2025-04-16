/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
*/

//Recursive approach
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        return recur(n1-1, n2-1, text1, text2);
    }

    public int recur(int i, int j, String text1, String text2){
        if(i<0 || j<0){
            return 0;
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + recur(i-1, j-1, text1, text2);
        }

        int case1 = recur(i-1, j, text1, text2);
        int case2 = recur(i, j-1, text1, text2);

        return Math.max(case1, case2);
    }
}

// Memoization approach
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int [][]dp = new int[n1+1][n2+1];
        for(int i=0; i<=n1; i++){
            for(int j=0; j<=n2; j++){
                dp[i][j] = -1;
            }
        }
        return recur(n1, n2, text1, text2,dp);
    }

    public int recur(int i, int j, String text1, String text2, int [][]dp){
        if(i==0 || j==0){
            dp[i][j] = 0;
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i-1) == text2.charAt(j-1)){
            dp[i][j] = 1 + recur(i-1, j-1, text1, text2, dp);
            return dp[i][j];
        }

        int case1 = recur(i-1, j, text1, text2, dp);
        int case2 = recur(i, j-1, text1, text2, dp);
        dp[i][j] = Math.max(case1, case2);
        return dp[i][j];
    }
}

// Bottom-up approach
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int [][]dp = new int[n1+1][n2+1];
        dp[0][0] = 0;
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }

    
}
