/*
January 10th 2022

Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


*/
import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        
        BigInteger bi1 = new BigInteger(a,2);
        BigInteger bi2 = new BigInteger(b,2);
        BigInteger bi3 = bi1.add(bi2);
        
        return bi3.toString(2);
    
    }
}
