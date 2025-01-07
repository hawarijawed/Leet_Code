/*
Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

A substring is a contiguous sequence of characters within a string
*/
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> lst = new ArrayList<>();

        Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));
        for(int i=0; i<words.length-1; i++){
            String st = words[i];
            for(int j = i+1; j<words.length; j++){
                if(words[j].contains(st)){
                    lst.add(st);
                    break;
                }
            }
        }

        return lst;
    }
}
