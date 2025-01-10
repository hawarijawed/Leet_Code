/*
You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.
*/
class Solution {
    public int[] getFreq(String word){
        int freq[] = new int[26];
        for(int i=0; i<word.length(); i++){
            freq[word.charAt(i) - 'a']++;
        }

        return freq;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq = new int[26];

        for(String word: words2){
            int temp[] = getFreq(word);
            for(int i=0; i<26; i++){
                freq[i] = Math.max(freq[i], temp[i]);
            }
        }

        List<String> lst = new ArrayList<>();

        for(String word: words1){
            int temp[] = getFreq(word);
            boolean flag = true;
            for(int i=0; i<26; i++){
                if(freq[i] > temp[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                lst.add(word);
            }
        }

        return lst;

    }
}
