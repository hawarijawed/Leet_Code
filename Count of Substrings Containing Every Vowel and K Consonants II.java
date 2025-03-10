/*
You are given a string word and a non-negative integer k.

Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.
*/
class Solution {
    public long countOfSubstrings(String word, int k) {
        return atLeast(k, word) - atLeast(k+1, word);
    }

    private boolean isConsonant(char ch){
        return (ch!='a'&& ch!='e' && ch!='i' && ch!='o' && ch!='u');
    }

    private boolean isAllVowels(int [] freq){
        return (freq['a' - 'a']>0 && freq['e' - 'a']>0 && freq['i' - 'a']>0
        && freq['o' - 'a']>0 && freq['u' - 'a']>0 );
    }

    private long atLeast(int k, String words){
        long count = 0;
        int curConsonant = 0;
        int []freq = new int[26];
        int n = words.length();
        int left = 0;
        for(int right=0; right<n; right++){
            char ch = words.charAt(right);
            if(isConsonant(ch)){
                curConsonant++;
            }
            freq[ch-'a']++;
            
            while(curConsonant >=k && isAllVowels(freq)){
                count += (n-right);
                char c = words.charAt(left);
                if(isConsonant(c)){
                    curConsonant--;
                }
                freq[c-'a']--;
                left++;
            }
        }

        return count;
    }
}
