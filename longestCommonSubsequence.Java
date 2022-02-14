/*
Feb 13th 2022

Given two strings text1 and text2, return the length of their longest common subsequence. 
If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters 
(can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.


*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i1 = text1.length() + 1;
        
        int j1 = text2.length() + 1;
        
        int[][] res = new int[i1][j1];
        
        for (int i = i1 - 2; i > -1; i--) {
            
            for (int j = j1 - 2; j > -1; j--) {
                
                if(text1.charAt(i) == text2.charAt(j)) {
                    res[i][j] = res[i + 1][j + 1] + 1;
                } else{
                    res[i][j] = Math.max(res[i][j + 1] , res[i + 1][j]);
                }
                
            }
        }

        
        return res[0][0];
    }
}
