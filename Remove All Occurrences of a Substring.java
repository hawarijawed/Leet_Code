/*
Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:

Find the leftmost occurrence of the substring part and remove it from s.
Return s after removing all occurrences of part.

A substring is a contiguous sequence of characters in a string.
*/
class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        int m = part.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(s.charAt(i));

            if(sb.length()>=m){
                String st = sb.substring(sb.length()-m);
                if(st.equals(part)){
                    sb.setLength(sb.length()-m);
                }
            }
        }

        return sb.toString();
    }
}
