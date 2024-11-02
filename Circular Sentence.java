/*
A sentence is a list of words that are separated by a single space with no leading or trailing spaces.

For example, "Hello World", "HELLO", "hello world hello world" are all sentences.
Words consist of only uppercase and lowercase English letters. Uppercase and lowercase English letters are considered different.

A sentence is circular if:

The last character of a word is equal to the first character of the next word.
The last character of the last word is equal to the first character of the first word.
For example, "leetcode exercises sound delightful", "eetcode", "leetcode eats soul" are all circular sentences. However, "Leetcode is cool", "happy Leetcode", "Leetcode" and "I like Leetcode" are not circular sentences.

Given a string sentence, return true if it is circular. Otherwise, return false.
*/
class Solution {
    // This method checks if a sentence is circular - where each word's last letter
    // matches the next word's first letter, and the last word's last letter matches
    // the first word's first letter
    public boolean isCircularSentence(String sentence) {
        // First check: verify if the first and last characters of the entire string match
        // This handles the requirement that the sentence should be circular
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1))
            return false;

        // Find the first space in the string
        int k = sentence.indexOf(" ");
        
        // If there are no spaces, it means there's only one word
        // In this case, we already checked if first and last letters match
        if (k == -1)
            return true;

        // Iterate through all spaces in the string
        while (k != -1) {
            // For each space found:
            // Check if the character before the space (last letter of current word)
            // matches the character after the space (first letter of next word)
            if (sentence.charAt(k - 1) != sentence.charAt(k + 1)) {
                return false;
            }

            // Find the next space in the string, starting from position after current space
            k = sentence.indexOf(" ", k+1);
        }
        
        // If we've made it through all checks, the sentence is circular
        return true;
    }
}
