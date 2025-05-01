/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int tempMax = nums[0];
        int cur = nums[0];

        for(int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            tempMax = Math.max(tempMax, cur);
        }

        return tempMax;
    }
}
