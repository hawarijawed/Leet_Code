/*
Alice and Bob are playing a game. Initially, Alice has a string word = "a".

You are given a positive integer k.

Now Bob will ask Alice to perform the following operation forever:

Generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word.
For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".

Return the value of the kth character in word, after enough operations have been done for word to have at least k characters.

Note that the character 'z' can be changed to 'a' in the operation.
*/

class Solution {
    public char kthCharacter(int k) {
        String word = "a";
        while(word.length() <= k){
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                if(ch == 'z'){
                    ch = 'a';
                }
                else{
                    ch++;
                }
                sb.append(ch);
            }

            word = sb.toString();
        }
       
        return word.charAt(k-1);
    }
}
