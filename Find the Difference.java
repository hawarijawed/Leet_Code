/*
You are given two strings s and t.

String t is generated by random shuffling string s and then add one more letter at a random position.

Return the letter that was added to t.
*/
class Solution {
    public char findTheDifference(String s, String t) {
        
        char res = 0;
        if(s.length() == 0) return t.charAt(0);
        for(char ch : s.toCharArray()){
            res ^= ch;
        }

        for(char ch: t.toCharArray()){
            res ^= ch;
        }

        return res;
    }
}
