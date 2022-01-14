/*
January 14th 2022

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        long pow_set_size = (long)Math.pow(2, nums.length);
        
        for(int i = 0; i < pow_set_size; i++) {
            
            ArrayList<Integer> a = new ArrayList<Integer>();
            
            for(int j = 0; j < nums.length; j++) {
                
                if((i & (1 << j)) > 0) {
                  a.add(nums[j]);  
                }
            }
            res.add(a);
        }
        
        return res;
    }
}
