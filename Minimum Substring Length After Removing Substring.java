/*
You are given a string s consisting only of uppercase English letters.

You can apply some operations to this string where, in one operation, you can remove any occurrence of one of the substrings "AB" or "CD" from s.

Return the minimum possible length of the resulting string that you can obtain.

Note that the string concatenates after removing the substring and could produce new "AB" or "CD" substrings.
*/
class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()==1){
            return 1;
        }
        stack.push(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            char ch = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);ch
                continue;
            }
            if((stack.peek() == 'A' && ch == 'B') || (stack.peek() == 'C' && ch=='D')){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }

        return stack.size();
    }
}
