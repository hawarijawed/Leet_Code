/*
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.
*/
class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder sb = new StringBuilder();
        int n1 = word1.length();
        int n2 = word2.length();
        int i =0, j=0;
        while(i < n1 && j<n2){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }
        while(i < n1){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j < n2){
            sb.append(word2.charAt(j));
            j++;
        }

        return sb.toString();
    }
}
