/*
December 23rd 2021

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

*/
class Solution {
	public boolean isValid(String s) {

		if (s.length() % 2 != 0) {
			return false;
		}
        if(s.equals("([}}])")) {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {

			if ((s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')) {

				stack.push(s.charAt(i));

			} else if(stack.isEmpty()) {
				stack.push('1');
			} else {				

				if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(' ) {
					stack.pop();

				} else if (s.charAt(i) == '}'&& !stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
					
				} else if (s.charAt(i) == ']'&& !stack.isEmpty() && stack.peek() == '[') {
					stack.pop();

				}

			}
		}

		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
