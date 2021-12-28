/*
December 28th 2021

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.


Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<Integer>(nums1.length + nums2.length);
        list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        
        List<Integer> list2 = new ArrayList<Integer>(nums2.length);
        list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        
        list1.addAll(list2);
        Collections.sort(list1);
        
//        System.out.println(3/2);
        double middle;
        if(list1.size() % 2 == 1) {
            middle = list1.get(list1.size()/2) ;
            
        } else {
//            System.out.println(list1.get(list1.size()/2)+":"+list1.get(list1.size()/2 - 1));
            middle = (Double.valueOf(list1.get(list1.size()/2)) +                   
                      Double.valueOf(list1.get(list1.size()/2 - 1)))/2;

        }
   
        return middle;
    }
}
