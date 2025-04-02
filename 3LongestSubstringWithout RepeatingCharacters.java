class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        } else if (s.length() == 0) {
            return 0;
        }
        Set<Character> res = new HashSet<>();
        int i = 0;
        int max = 0;
        //j right, i left
        for (int j = 0; j < s.length(); j++) {

            if (!res.contains(s.charAt(j))) {
                res.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
            } else {
                while (res.contains(s.charAt(j))) {
                    res.remove(s.charAt(i));
                    i++;
                }
                res.add(s.charAt(j));
            }

        }
        return max;
    }

}
