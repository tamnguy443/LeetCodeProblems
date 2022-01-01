/*
January 1st, 2022 !!

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. 
The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. 
More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. 
It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int j=0; //Index of unique elements
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[j]){ // Only when it is not same as the previous unique element
                nums[++j] = nums[i];// Incrementing the index while assigning the new value
            }
        }
        return ++j;// need to return number of elements instead of index
    }
}
