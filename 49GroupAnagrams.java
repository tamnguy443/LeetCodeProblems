/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        if(strs.length == 1) {
            List<String> blank = new ArrayList<>();
            blank.add(strs[0]);
            res.add(blank);
            return res;
        } else {
            List<String> blank = new ArrayList<>();
            blank.add(strs[0]);
            res.add(blank);
        }

        for(int i = 1; i < strs.length; i++) {
            for(int j = 0; j < res.size(); j++) {
                boolean ana = areAnagrams(strs[i], res.get(j).get(0));

                if(ana) {
                    res.get(j).add(strs[i]);
                    break;

                } else if(!ana && j == res.size() - 1) {
                    List<String> blank = new ArrayList<>();
                    blank.add(strs[i]);
                    res.add(blank);
                    break;
                }
            }
        }
        return res;
    }

    public boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }
}
