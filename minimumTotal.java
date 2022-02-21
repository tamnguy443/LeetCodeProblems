/*
Feb 20th, 2022

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, 
you may move to either index i or index i + 1 on the next row.

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //make empty arr of 0 length 1 greater than last row of triangle
        int[] dp = new int[triangle.size() + 1];
        
        for(int i = triangle.size() - 1; i > -1; i--) {
            
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
         
            }     
        }    
        return dp[0];
    }
}
