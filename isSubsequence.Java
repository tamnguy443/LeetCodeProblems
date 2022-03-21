/*
March 21st 2022

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by 
deleting some (can be none) of the characters without disturbing the relative positions of 
the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
*/
class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int j = 0;
        
        for(int i = 0; i < t.length(); i++) {   
            if(j < s.length() && s.charAt(j) == t.charAt(i)) {
                j = j + 1;
                
            }
        }
        
        if(j == s.length()) {
            return true;
        } else return false;
        
    }
}
