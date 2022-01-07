/*
January 7th, 2022

Given an integer rowIndex, return the rowIndexth (0-indexed) 
row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers 
directly above it as shown:

*/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        result.add(a);
        
        for(int i = 0; i < rowIndex; i++) {
            ArrayList<Integer> b = new ArrayList<Integer>();
            b.add(0);
            b.addAll(result.get(result.size() - 1));
            b.add(0);
            ArrayList<Integer> c = new ArrayList<Integer>();
            for(int j = 0; j < result.get(result.size() - 1).size() + 1; j++) {
                c.add(b.get(j) + b.get(j + 1));
            }
            result.add(c);
        } 
        
        return result.get(rowIndex);
    }
}
