/*
December 20th 2021

Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2^x.
*/
class Solution {
    public boolean isPowerOfTwo(int n) {
        
        for (int i = 0; i < 31; i++) {
            if(Math.pow(2, i) == n) {
                return true;
            }
        }
        
        return false;
    }
}
