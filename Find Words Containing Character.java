/*
You are given a 0-indexed array of strings words and a character x.

Return an array of indices representing the words that contain the character x.

Note that the returned array may be in any order.
*/
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            String st = words[i];
            for(char ch: st.toCharArray()){
                if(ch == x){
                    res.add(i);
                    break;
                }
            }
        }

        return res;
    }
}
