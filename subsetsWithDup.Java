/*
Feb 5th 2022

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

*/
class Solution {
    
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        
        backtrack(0, nums, new ArrayList<>(), false);
        
        return res;
    }
    
    public void backtrack(int i, int[] nums, List<Integer> ls, boolean a) {
        if(i == nums.length) {
            res.add(new ArrayList<>(ls));
            return;
        }
        
        backtrack(i + 1,nums,ls,false);
        if(i >= 1 && nums[i] == nums[i-1] && !a) return;
        ls.add(nums[i]);
        backtrack(i + 1,nums,ls,true);
        ls.remove(ls.size()-1);
        
    }
}
