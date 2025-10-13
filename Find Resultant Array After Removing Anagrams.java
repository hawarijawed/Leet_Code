/*
You are given a 0-indexed string array words, where words[i] consists of lowercase English letters.

In one operation, select any index i such that 0 < i < words.length and words[i - 1] and words[i] are anagrams, and delete words[i] from words. Keep performing this operation as long as you can select an index that satisfies the conditions.

Return words after performing all operations. It can be shown that selecting the indices for each operation in any arbitrary order will lead to the same result.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase using all the original letters exactly once. For example, "dacb" is an anagram of "abdc".
*/

// In efficient approach
class Solution {
    public List<String> removeAnagrams(String[] words) {
        ArrayList<String> lst = new ArrayList<>();
        for(String word: words){
            lst.add(word);
        }

        int i = 1;
        while(i<lst.size()){
            if(isAnagram(lst.get(i-1), lst.get(i))){
                lst.remove(i);
                i=1;
            }
            else{
                i++;
            }
        }

        return lst;
    }

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(char ch: s.toCharArray()){
            arr1[ch - 'a']++;
        }
        for(char ch: t.toCharArray()){
            arr2[ch - 'a']++;
        }

        for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}

// Optimized approach
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prevKey = "";

        for (String word : words) {
            String currKey = sortString(word);
            if (!currKey.equals(prevKey)) {
                result.add(word);
                prevKey = currKey;
            }
        }

        return result;
    }

    // Helper method to sort the characters of a string
    private String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
