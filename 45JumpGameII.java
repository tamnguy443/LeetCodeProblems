/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
*/
class Solution {
    public int jump(int[] nums) {
        int[] res = new int[nums.length];
        res[nums.length - 1] = 0;
        // initialise all to max possible jumps + 1 denoting dp[i] hasn't been computed yet
        for(int i = 0; i < res.length - 2; i++) {
            res[i] = 10001;
        }
// start from last index. No jumps required to reach end if we are already here
// same as above. For each index, explore all jump sizes and use the one requiring minimum jumps to reach end
        for(int i = nums.length - 2; i >= 0; i--) {
            for(int j = 1; j <= nums[i]; j++) {

                // min(n-1, i + jumpLen) for bounds handling
                res[i] = Math.min(res[i], 1 + res[Math.min(nums.length - 1, i + j)]);
            }
        }

        return res[0];
    }
}
