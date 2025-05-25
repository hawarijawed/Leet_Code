/*
You are given an array of strings words. Each element of words consists of two lowercase English letters.

Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.

Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.

A palindrome is a string that reads the same forward and backward.
*/
class Solution {
    public int longestPalindrome(String[] words) {
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){
            String rev = new StringBuilder(word).reverse().toString();
            
            if(map.containsKey(rev) && map.get(rev) > 0){
                res += 4;
                map.put(rev, map.get(rev)-1);
            }
            else{
                map.put(word, map.getOrDefault(word,0)+1);
            }
        }
        for (String word : map.keySet()) {
            if (word.charAt(0) == word.charAt(1) && map.get(word) > 0) {
                res += 2;
                break; // Only one center allowed
            }
        }
        
        return res;
    }
}
