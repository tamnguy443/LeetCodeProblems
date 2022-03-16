/*
March 15th, 2022

The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long 
sequences (substrings) that occur more than once in a DNA molecule. 
You may return the answer in any order.

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
*/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<String>();
        HashSet<String> res = new HashSet<String>();
        ArrayList<String> result = new ArrayList<String>();
        
        for(int i = 0; i < s.length() - 9; i++) {
            String cur = s.substring(i, i + 10);
            if(seen.contains(cur)) res.add(cur);
            seen.add(cur);
                       
        }
 
        return new ArrayList<>(res);
    }
}
