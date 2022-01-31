/*
January 30th, 2022

You are given an integer array coins representing coins of different denominations and an integer 
amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot 
be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        for(int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;    
        }
        dp[0] = 0;
        
        for(int i = 0; i < amount + 1; i++) {
            for(int j : coins) {
                if( i - j >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - j]);
                }
            }
        }
        
        if(dp[amount] != amount + 1) {
            return dp[amount];
        } else {
            
            return -1;
        }
        
    }
}
