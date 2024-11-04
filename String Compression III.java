/*
Given a string word, compress it using the following algorithm:

Begin with an empty string comp. While word is not empty, use the following operation:
Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
Append the length of the prefix followed by c to comp.
Return the string comp.
*/
class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int i = 0; // Pointer to traverse the word

        while (i < word.length()) {
            char currentChar = word.charAt(i);
            int count = 0;

            // Count the length of the prefix of the same character
            while (i < word.length() && word.charAt(i) == currentChar && count < 9) {
                count++;
                i++;
            }

            // Append the count and the character to the compressed string
            comp.append(count).append(currentChar);
        }

        return comp.toString();
    }
}
