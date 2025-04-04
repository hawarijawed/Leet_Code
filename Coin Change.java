/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
*/
class Solution {
   
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int res = maxCoin(coins, amount, n-1);
        if(res ==  (int)(1e7)){
            return -1;
        }

        return res;
    }

    public int maxCoin(int [] coins, int amount, int index){
        //Base case
        if(amount == 0) return 0;
        if(index == 0){
            if(amount % coins[0] == 0){
                return amount/coins[0];
            }

            return (int)(1e7);
        }

        //Pick logic
        int pick = (int)(1e7);
        if(amount >= coins[index]){
            pick = 1 + maxCoin(coins, amount - coins[index], index);
        }

        //No pick logic
        int no_pick = maxCoin(coins, amount, index-1);

        return Math.min(pick, no_pick);
    }
}

//Using dp solution
class Solution {
   
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n][amount+1];
        int C = (int)(1e7);
        for(int i= 0; i<n; i++){
            for(int j=0; j<=amount; j++){
                dp[i][j] = C;
            }
        }
        int res = maxCoin(coins, amount, n-1, dp);
        if(res ==  C){
            return -1;
        }

        return res;
    }

    public int maxCoin(int [] coins, int amount, int index, int[][]dp){
        //Base case
        if (amount == 0) return 0;
        if(index == 0){
            if(amount % coins[0] == 0){
                dp[0][amount] = amount/coins[0];
                return dp[0][amount];
            }

            dp[0][amount] = (int)(1e7);
            return dp[0][amount];
        }
        if(dp[index][amount] != (int)(1e7)) return dp[index][amount];
        //Pick logic
        int pick = (int)(1e7);
        if(amount >= coins[index]){
            pick = 1 + maxCoin(coins, amount - coins[index], index,dp);
        }

        //No pick logic
        int no_pick = maxCoin(coins, amount, index-1,dp);

        dp[index][amount] = Math.min(pick, no_pick);
        return dp[index][amount];
    }
}

//Using Tabulation method
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0) return 0;
        if(n == 1){
            if(amount % coins[0] == 0){
                return amount/coins[0];
            }
            return -1;
        }
        int [][] dp = new int[n][amount+1];
        int C = (int)(1e7);
        //When index = 0;
        for(int i=0; i<=amount; i++){
            if(i%coins[0] == 0){
                dp[0][i] = i / coins[0];
            }
            else{
                dp[0][i] = C;
            }
        }

        for(int index = 1; index < n; index++){
            for(int j=0; j<=amount; j++){
                int pick = C;
                if(j >= coins[index]){
                    //maxCoin(coins, amount - coins[index], ind,dp);
                    pick = 1 + dp[index][j-coins[index]]; 
                }

                int no_pick = dp[index - 1][j];

                dp[index][j] = Math.min(pick, no_pick);
            }
        }

        return dp[n - 1][amount] == C ? -1 : dp[n - 1][amount];
    }

}
