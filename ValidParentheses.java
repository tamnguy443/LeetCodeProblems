/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 2:
Input: s = "()[]{}"
Output: true
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if((c == ')' || c == ']' || c == '}') && !stack.isEmpty() ) {
                if(isPair(stack.peek(),c)) {
                    stack.pop();
                    
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }

        }

        return stack.isEmpty();
    }

    private boolean isPair(char last, char cur) {
        return (last == '(' && cur == ')') ||
               (last == '{' && cur == '}') ||
               (last == '[' && cur == ']');
    }   
}
