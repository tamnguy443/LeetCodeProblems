/*
Feb 7th 2022

Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

*/
class Solution {
    public boolean isMatch(String s, String p) {
        
        
        //top down memoization
        
        return dfs(s,p,0,0);
        
    }
    
    public boolean dfs(String s, String p, int i, int j) {
        //recursive
        
        if(i >= s.length() && j >= p.length()) {
            return true;
        }
        if(j >= p.length()) {
            return false;
        }
        
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
            
            return dfs(s,p,i, j + 2) || //dont use *
            match && dfs(s,p,i + 1, j); //use *
        }
        
        if(match) {
            return dfs(s,p,i + 1, j + 1);
        }
        
        return false;
        
    }
}
