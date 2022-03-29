/*
March 29th 2022

Given an array of integers nums containing n + 1 
integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the 
array nums and uses only constant extra space.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
*/
class Solution {
    public int findDuplicate(int[] nums) {
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 1; i++) {
            
            if(nums[i] == nums[i + 1]) return nums[i];
            
        }
        
        return -1;       
        
    }
}
/*
    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        
        boolean[] boo = new boolean[nums.length];
        //default bool is false
        
        for(int i = 0; i < nums.length; i++){
        
            if(boo[nums[i]]) {
                return nums[i];
            }
        
            boo[nums[i]] = true;
            
        }
    
        return -1;
    }
*/
