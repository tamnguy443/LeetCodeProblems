/*
March 22nd 20022

Given an integer array nums of length n and an integer target, 
find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        int close = nums[0] + nums[1] + nums[nums.length - 1];;
        
        for(int i = 0; i < nums.length; i++) {
            
            int l = i + 1;
            int r = nums.length - 1;
            
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                
                if(sum > target) {
                    
                    if(Math.abs(target - close) > Math.abs(target - sum)) {
                        close = sum;
                        
                    }                  
                    
                    r = r - 1;
                    
                } else if(sum < target) {
                    
                    if(Math.abs(target - close) > Math.abs(target - sum)) {
                        close = sum;
                        
                    }
                    
                    l = l + 1;
                    
                } else {
                    
                    return sum;
                    
                }
            }
        }
        
        return close; 
        
    } 
}
