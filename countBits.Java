/*
January 19th 2022

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
ans[i] is the number of 1's in the binary representation of i.

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

*/
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        
        for(int i = 0; i <= n; i++) {
            String a = Integer.toBinaryString(i);
            int count = 0;
            int l = a.length();
            
            for(int j = 0; j < l; j++) {
                
                if(a.charAt(j) == '1') { 
                    res[i] = res[i] + 1;
                }
            }
            
            count = 0;
        }
        
        return res;
    }
}
