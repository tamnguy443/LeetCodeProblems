/*
Feb 27th 2022

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                dp[i][j] = 500;
                
            }
        }
        
        for(int i = 0; i < dp.length; i++) {
            dp[i][word2.length()] = word1.length() - i;
        }
        for(int j = 0; j < dp[0].length; j++) {
            dp[word1.length()][j] = word1.length() - j;
        }
        
        
        for(int i = word1.length() - 1; i > -1; i-- ) {
            for(int j = word2.length() - 1; j > -1; j-- ) {
                if(word1.charAt(i) == word2.charAt(j)) {
                    
                    dp[i][j] = dp[i + 1][j + 1];
                       
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i + 1][j + 1],dp[i][j + 1]),dp[i + 1][j]);
                }
            }
        }
        
        
        return dp[0][0];
    }
}
