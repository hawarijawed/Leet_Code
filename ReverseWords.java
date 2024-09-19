/*
Given a String str, reverse the string without reversing its individual words. Words are separated by dots.
Note: The last character has not been '.'.
*/

class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
        Stack<String> stack = new Stack<>();
        //dot(.) is a regular expression that matches any character 
        //In order to split the string based on dot(.) use "\\."
        String [] arr = str.split("\\.");
        for(int i=0; i<arr.length; i++){
            stack.push(arr[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
            if(stack.isEmpty()){
                break;
            }
            sb.append(".");
        }
        
        return sb.toString();
    }
}
