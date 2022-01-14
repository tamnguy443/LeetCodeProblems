/*
January 13th 2022

Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must be unique and you may return the result in any order.

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> res = new HashSet<Integer>();
        
        List<Integer> list1 = new ArrayList<Integer>();
        
        for(Integer text:nums2) {
            list1.add(text);
        }
        
        for(Integer in:nums1) {
            if(list1.contains(in)) {
                res.add(in);
            }
            
        }
        int[] arr1 = new int[res.size()];
        
        Object[] arr = res.toArray();
        
        for(int i = 0; i < res.size(); i++) {
            
            arr1[i] = (int) arr[i];
        }
        
        return arr1;
    }
}
