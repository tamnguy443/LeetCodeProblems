/*
April 10th 2022

You are keeping score for a baseball game with strange rules. 
The game consists of several rounds, 
where the scores of past rounds may affect future rounds' scores.

At the beginning of the game, you start with an empty record. 
You are given a list of strings ops, 
where ops[i] is the ith operation you must apply to 
the record and is one of the following:

An integer x - Record a new score of x.
"+" - Record a new score that is the sum of the previous two scores.
It is guaranteed there will always be two previous scores.
"D" - Record a new score that is double the previous score. 
It is guaranteed there will always be a previous score.
"C" - Invalidate the previous score, removing it from the record. 
It is guaranteed there will always be a previous score.
Return the sum of all the scores on the record.

Example 1:

Input: ops = ["5","2","C","D","+"]
Output: 30
Explanation:
"5" - Add 5 to the record, record is now [5].
"2" - Add 2 to the record, record is now [5, 2].
"C" - Invalidate and remove the previous score, record is now [5].
"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
The total sum is 5 + 10 + 15 = 30.
*/
class Solution {
    public int calPoints(String[] ops) {
        int res = 0;
        Stack<String> stack = new Stack<String>();
        

        for(int i = 0; i < ops.length; i++) {
            
            if(ops[i].equals("+")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.peek());
                String c = (a+b) + "";
                stack.push(a+"");
                stack.push(c);
                    
            } else if(ops[i].equals("C")) {
                stack.pop();
                
            } else if(ops[i].equals("D")) {
                int a = Integer.parseInt(stack.peek());
                String c = (a*2) + "";
                stack.push(c);
                
            } else {
                stack.push(ops[i]);
                
            }
        }
        System.out.print(stack);
        while(!stack.empty()){
            res = res + Integer.parseInt(stack.pop());
        }
        
        return res;
    }
}
