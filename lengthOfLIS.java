/*
March 6th, 2022

Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array 
by deleting some or no elements without changing the order of the remaining elements. 
For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        
        for(int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        
        for(int i = nums.length - 1; i > -1; i--) {
                       
            for(int j = i + 1; j < nums.length; j++) {
                
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }                         
            }           
        }
        int max = 0;
        
        for(int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
