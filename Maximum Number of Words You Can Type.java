/*
There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.

Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.
*/
class Solution {
    public int canBeTypedWords(String text, String broken) {
        Set<Character> brokenKeys = new HashSet<>();
        int count = 0;

        for (char c : broken.toCharArray()) {
            brokenKeys.add(c);
        }

        String[] words = text.split(" ");

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (brokenKeys.contains(c)) {
                    count++;
                    break;
                }
            }
        }

        return words.length - count;
    }
}
