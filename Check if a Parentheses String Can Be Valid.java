/*
A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:

It is ().
It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
It can be written as (A), where A is a valid parentheses string.
You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked,

If locked[i] is '1', you cannot change s[i].
But if locked[i] is '0', you can change s[i] to either '(' or ')'.
Return true if you can make s a valid parentheses string. Otherwise, return false.
*/
class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n%2 != 0) return false;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            char state = locked.charAt(i);

            if(state == '0'){
                unlocked.push(i);
            }
            else if(ch == '('){
                stack.push(i);
            }
            else{ //Locked and closing paranthesis state
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    if(!unlocked.isEmpty()){
                        unlocked.pop();
                    }
                    else{
                        return false;
                    }
                }
                
            }
        }

        while(!stack.isEmpty() && !unlocked.isEmpty() && stack.peek() < unlocked.peek()){
            stack.pop();
            unlocked.pop();
        }

        return stack.isEmpty();
        
    }
}
