/*
You are given a string s consisting of lowercase English letters ('a' to 'z').

Your task is to:

Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
Find the consonant (all other letters excluding vowels) with the maximum frequency.
Return the sum of the two frequencies.

Note: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them. If there are no vowels or no consonants in the string, consider their frequency as 0.

The frequency of a letter x is the number of times it occurs in the string.
*/
class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> vowels = new HashMap<>();
        HashMap<Character, Integer> consonants = new HashMap<>();
        vowels.put('a', 0);
        vowels.put('e', 0);
        vowels.put('i', 0);
        vowels.put('o', 0);
        vowels.put('u', 0);
        int maxVowel = 0;
        int maxConsonant = 0;
        for(char ch: s.toCharArray()){
            if(vowels.containsKey(ch)){
                vowels.put(ch, vowels.get(ch) + 1);
                maxVowel = Math.max(maxVowel, vowels.get(ch));
            }
            else{
                consonants.put(ch, consonants.getOrDefault(ch, 0) + 1);
                maxConsonant = Math.max(maxConsonant, consonants.get(ch));
            }
        }

        return maxVowel+maxConsonant;
    }
}
