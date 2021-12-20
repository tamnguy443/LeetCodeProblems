/*
December 18th 2021

Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.
*/

class Solution {
    public boolean isPalindrome(int x) {
        //concat to make string
        String xx = x + "";
        String test ="";
        char ch;
        
        for(int i = 0; i < xx.length(); i++) {
            ch = xx.charAt(i); //extracts each character
            test= ch+test; //adds each character in front of the existing string 
        }
        System.out.println("Reversed word: "+ test);
        
        if (xx.equals(test)) {
            return true;
        } else {
            return false;
        }
        
    }
}
