/*
December 27th 2021

The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.


Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
*/
class Solution {
    public int findComplement(int num) {
        String x = Integer.toBinaryString(num);
		String ans = "";
        for (int i = 0; i < x.length(); i++) {
        	int y = Integer.parseInt(x.charAt(i) + "") ^ 1;
        	ans = ans + y + "";
        }
        return Integer.parseInt(ans,2);
    }
}
