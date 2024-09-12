/*
You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.
*/
//------------------------------- Approach 1: Using HashSet function -------------------------------//
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        for(char ch:allowed.toCharArray()){
            set.add(ch);
        }
        int count = words.length;
        for(String str1: words){
            for(int i=0; i<str1.length(); i++){
                char ch1 = str1.charAt(i);
                if(!set.contains(ch1)){
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}

//------------------------------- Approach 2: Using Bit Manipulation -------------------------------//
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int bit_mask = 0;
        for(char ch: allowed.toCharArray()){
            int bit = 1<<(ch-'a');
            bit_mask = bit | bit_mask;
        }
        int count = words.length;
        for(String str1: words){
            for(int i=0; i<str1.length(); i++){
                char ch1 = str1.charAt(i);
                int bit = 1<<(ch1-'a');
                if((bit & bit_mask) == 0){
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}
