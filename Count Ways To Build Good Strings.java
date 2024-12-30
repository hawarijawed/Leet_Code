/*
Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each step perform either of the following:

Append the character '0' zero times.
Append the character '1' one times.
This can be performed any number of times.

A good string is a string constructed by the above process having a length between low and high (inclusive).

Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, return it modulo 109 + 7.
*/
class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int maxLen = high + Math.max(zero, one);
        int dp [] = new int[maxLen+1];
        Arrays.fill(dp, -1);

        return recur(low, high, zero, one, 0, dp);
    }
    public int recur(int low, int high, int zero, int one, int len, int dp[]){
        if(len>high){
            dp[len] = 0;
            return 0;
        }

        if(dp[len] != -1){
            return dp[len];
        }
        int zeroLen = len + zero;
        int oneLen = len + one;
        int zeroCount = (zeroLen >= low && zeroLen <= high)?1:0;
        int oneCount = (oneLen >= low && oneLen <= high)?1:0;
        int res = zeroCount + recur(low, high, zero, one, zeroLen, dp)+
        oneCount + recur(low, high, zero, one, oneLen, dp);

        dp[len] = res%(1000000007);
        return dp[len];
    }
}
