/*
February 1st, 2022

ou are given an integer array coins representing coins of different denominations 
and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money 
cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
*/
class Solution {
    public int change(int amount, int[] coins) {
       //You may assume that you have an infinite number of each kind of coin.
        int[] dp = new int[amount + 1];
        
        dp[0] = 1;
        
        for(int i = coins.length - 1; i > -1; i--) {
            int[] nextdp = new int[amount + 1];
            nextdp[0] = 1;
            
            for(int a = 1; a < amount + 1; a++) {
                nextdp[a] = dp[a];
                
                if(a - coins[i] >= 0) {
                    nextdp[a] += nextdp[a - coins[i]];
                }
                
            }
            dp = nextdp;
            
        }
        
        return dp[amount];
    }
}
