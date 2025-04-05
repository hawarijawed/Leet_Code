/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.
*/         
//Recursive Solution
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        return recur(coins, amount, n-1);
    }

    public int recur(int [] coins, int amount, int index){
        //base case
        if(amount == 0) return 1;
        if(index == 0){
            if(amount % coins[0] == 0){
                return 1;
            }
            return 0;
        }

        //Applying pick and noPick logic
        int pick = 0;
        if(amount >= coins[index]){
            pick = recur(coins, amount - coins[index], index);
        }

        int no_pick = recur(coins, amount, index-1);

        return pick + no_pick;
    }
}

// Top Down dp approach
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        if(amount  == 0) return 1;
        int [][] dp = new int[n][amount+1];
        return recur(coins, amount, n-1,dp);
    }

    public int recur(int [] coins, int amount, int index, int[][] dp){
        //base case
        if(amount == 0) return 1;
        if(index == 0){
            if(amount % coins[0] == 0){
                dp[0][amount] = 1;
                return dp[0][amount];
            }
            dp[0][amount] = 0;
            return dp[0][amount];
        }

        if(dp[index][amount] != 0) return dp[index][amount];
        //Applying pick and noPick logic
        int pick = 0;
        if(amount >= coins[index]){
            pick = recur(coins, amount - coins[index], index,dp);
        }

        int no_pick = recur(coins, amount, index-1,dp);

        dp[index][amount] = pick + no_pick;
        return dp[index][amount];
    }
}


// Tabulation method
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        if(amount  == 0) return 1;
        int [][] dp = new int[n][amount+1];
        //For index i =0
        for(int a = 0; a<=amount; a++){
            if(a%coins[0] == 0){
                dp[0][a] = 1;
            }
        }

        for(int index =1; index < n; index++){
            for(int a=0; a<=amount; a++){
                int pick = 0;
                if(a>=coins[index]){
                    pick = dp[index][a - coins[index]];
                }

                int no_pick = dp[index-1][a];

                dp[index][a] = pick + no_pick;
            }
        }
        return dp[n-1][amount];
    }
}
