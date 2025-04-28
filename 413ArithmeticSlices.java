/*
An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.
A subarray is a contiguous subsequence of the array.

Example 1:

Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
*/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) {
            return 0;
        }
        int res = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] - nums[i + 1] == nums[i + 1] - nums[i + 2]) {

                for(int j = i + 2; j < nums.length; j++) {
                    if(nums[j] - nums[j-1] == nums[j-1] - nums[j-2]) {
                        res++;
                    } else {
                        break;
                    }
                }
            }

        }


        return res;
    }
}
