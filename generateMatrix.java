/*
April 17th 2022

Given a positive integer n, generate an n x n matrix 
filled with elements from 1 to n2 in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:
Input: n = 1
Output: [[1]]

*/
class Solution {
    public int[][] generateMatrix(int n) {
        //List<Integer> res = new ArrayList<Integer>();
        int[][] resu = new int[n][n];
        int top = 0; //top left row start
        int bottom = resu.length - 1; //bottom left row start
        int left = 0; //top left column start
        int right = resu[0].length - 1; //right column start
        int j = 1;
        while(true){
            
            for(int i = left; i <= right; i++){
                //res.add(matrix[top][i]);
                resu[top][i] = j;
                j++;
            } 
            top++;
            if(top > bottom) break;
            
            for(int i = top; i <= bottom; i++) {
                //res.add(matrix[i][right]);
                resu[i][right] = j;
                j++;
            } 
            right--;
            if(left > right) break;
            
            for(int i = right; i >= left; i--) {
                //res.add(matrix[bottom][i]);
                resu[bottom][i] = j;
                j++;
            } 
            bottom--;
            if(top > bottom) break;
            
            for(int i = bottom; i >= top; i--) {
                //res.add(matrix[i][left]);
                resu[i][left] = j;
                j++;
            } 
            left++;
            if(left > right) break;
            
        }
        
        return resu;
        
    }
}
