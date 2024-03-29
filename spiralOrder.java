/*
April 12th 2022

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        int top = 0; //top left row start
        int bottom = matrix.length - 1; //bottom left row start
        int left = 0; //top left column start
        int right = matrix[0].length - 1; //right column start
        
        while(true){
            
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            } 
            top++;
            if(top > bottom) break;
            
            for(int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            } 
            right--;
            if(left > right) break;
            
            for(int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            } 
            bottom--;
            if(top > bottom) break;
            
            for(int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            } 
            left++;
            if(left > right) break;
            
        }
        
        return res;
    }
    
}
