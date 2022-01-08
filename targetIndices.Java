/*
January 7th 2022

You are given a 0-indexed integer array nums and a target element target.

A target index is an index i such that nums[i] == target.

Return a list of the target indices of nums after sorting nums in non-decreasing order. 
If there are no target indices, return an empty list. The returned list must be sorted in increasing order.

*/

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(Integer text:nums) {
         list.add(text);
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == target) {
                res.add(i);
            }
        }
        
        return res;
    }
}
