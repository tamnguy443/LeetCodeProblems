/*
Feb 4th 2022

Given a non-empty array nums containing only positive integers, 
find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].


*/
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        
        if(sum % 2 == 1) {
            return false;
        }
        
        Set<Integer> dp = new HashSet<Integer>();
        
        
        dp.add(0);
        
        for(int i = nums.length - 1; i > -1; i--) {
            
            Set<Integer> nextDp = new HashSet<Integer>();
            Iterator<Integer> itr = dp.iterator();
            
            while(itr.hasNext()) {
                
                int x = itr.next();
                
                nextDp.add(x + nums[i]);
                nextDp.add(x);
            }
            
            dp = nextDp;
            
        }
        
        if(dp.contains(sum / 2)) return true;
        else return false;
        
    }
}
