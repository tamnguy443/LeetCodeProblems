/*
April 5th 2022

The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
*/
class Solution {
    public int tribonacci(int n) {
        
        if(n == 0) return 0;
        else if(n == 1 || n == 2) return 1;
        
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        int res = 0;
        
        for(int i = 2 ; i < n; i++) {
            res = t0 + t1 + t2;
            
            t0 = t1;
            t1 = t2;
            t2 = res;
        }
        
        return res;
    }
}
