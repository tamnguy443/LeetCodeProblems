/*
March 1st 2022

Given an integer array nums, find a contiguous non-empty subarray 
within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

*/
class Solution {
    public int maxProduct(int[] nums) {
        int res = 0;
        
        for(int n : nums) {
            if (n > res) res = n;
        }
        
        int curMax = 1;
        int curMin = 1;
        
        for(int n : nums) {
            
            if(n == 0) {
                curMax = 1;
                curMin = 1;
            }
            int temp = n * curMax;
            curMax = Math.max(
                n * curMax, Math.max(
                n * curMin, n 
                )
            );
            
            curMin = Math.min(
                temp, Math.max(
                n * curMin, n 
                )
            );
            
            res = Math.max(res, curMax);
        }
        
        return res;
    }
}
