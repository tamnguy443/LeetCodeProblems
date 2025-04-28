/*
Given an integer array nums, return the number of subarrays of length 3 such that the sum of the first and third numbers equals exactly half of the second number.

Example 1:
Input: nums = [1,2,1,4,1]

Output: 1

Explanation:
Only the subarray [1,4,1] contains exactly 3 elements where the sum of the first and third numbers equals half the middle number.
*/
class Solution {
    public int countSubarrays(int[] nums) {
        int res = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            double a = nums[i];
            double b = nums[i + 2];
            double c = nums[i + 1] / 2.0;
            if(a + b == c) {
                res++;
                System.out.println(c);
            }
   
        }

        return res;
    }
}
