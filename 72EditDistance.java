/*
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

        for(int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }

        for(int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i < word1.length() + 1; i++) {

            for(int j = 1; j < word2.length() + 1; j++) {
                
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], 
                        Math.min(dp[i - 1][j],dp[i][j - 1])) + 1;
                }
                
            }

        }

        return dp[word1.length()][word2.length()];
    }
}
