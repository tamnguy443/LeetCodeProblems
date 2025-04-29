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
        int near = 0;
        int far = 0;
        int jump = 0;

        while(far < nums.length - 1) {
            int farthest = 0;

            for(int i = 0; i < far + 1; i++) {
                //farthest = max of farthest and current position of max jump
                farthest = Math.max(farthest, i + nums[i]);

            }
            jump++;
            near = far + 1;
            far = farthest;
        }

        return jump;
    }
}
