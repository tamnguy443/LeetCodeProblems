/*
January 26th 2022

Given an array of positive integers nums and a positive integer target, 
return the minimal length of a contiguous subarray 
[numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. 
If there is no such subarray, return 0 instead.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //shifting window
        int l = 0;
        int total = 0;
        int min = nums.length + 1;
        
        for(int r = 0; r < nums.length; r++) {
            total = total + nums[r];
            while(total >= target) {
                min = Math.min(r - l + 1, min);
                total = total - nums[l];
                l++;
            }
        }
        
        
        if(min == nums.length + 1) {
            //no such subarray
            return 0;
        }
        
        return min;
    }
}
