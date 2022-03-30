/*
March 30th 2022

Write an efficient algorithm that searches for a value target in an m x n 
integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int i = 0; i < matrix.length; i++) {
            
            if(target > matrix[i][matrix[i].length - 1]) continue;
            
            int l = 0;
            int r = matrix[i].length;
        
            while(r != l) {
                int m = (r + l) / 2;
            
                if(matrix[i][m] < target) {
                    l++;  
                
                } else if(matrix[i][m] > target) {
                    r--;
                
                } else {
                
                    return true;
                }
            
            }
        }
        
        return false;
    }
}
