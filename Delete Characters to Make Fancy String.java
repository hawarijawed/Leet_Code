/*
A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.
*/
//-------------------------------- Using Stack -------------------------------//
class Solution {
    public String makeFancyString(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char ch: s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(ch);
                count++;
            }
            else{
                if(stack.peek() != ch){
                    stack.push(ch);
                    count=1;
                    continue;
                }
                if(stack.peek() == ch && count < 2){
                    stack.push(ch);
                    count++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb = sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
//-------------------------------- Using StringBuilder -------------------------------//
class Solution {
    public String makeFancyString(String s) {
        //sb.charAt(sb.length() - 2)
        StringBuilder result = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            // Check the last two characters in the result
            int length = result.length();
            if (length >= 2 && result.charAt(length - 1) == c && result.charAt(length - 2) == c) {
                // If the last two characters are the same as the current character, skip adding it
                continue;
            }
            // Otherwise, append the character to the result
            result.append(c);
        }
        
        return result.toString();
   }
}
