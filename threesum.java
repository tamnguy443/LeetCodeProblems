/*
March 8th, 2022

Given an integer array nums, return all the triplets 
[nums[i], nums[j], nums[k]] such that i != j, i != k, and 
j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        
        for(int i = 0; i < nums.length; i++) {
            
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int l = i + 1;
            int r = nums.length - 1;
            
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                
                if(sum > 0) {
                    
                    r = r - 1;
                    
                } else if(sum < 0) {
                    
                    l = l + 1;
                    
                } else {
                    
                    ArrayList<Integer> res1 = new ArrayList<>();
                    res1.add(nums[i]);
                    res1.add(nums[l]);
                    res1.add(nums[r]);
                    
                    res.add(res1);
                    l = l + 1;
                    
                    while(nums[l] == nums[l - 1] && l < r) {
                        
                        l = l + 1;  
                    }
                }
            }
        }
        
        return res;
        
    } 
}
