/*
A sentence is a string of single-space separated words where each word consists only of lowercase letters.
A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.
*/
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordFreq1 = new HashMap<>();
        Map<String, Integer> wordFreq2 = new HashMap<>();
        String sen1Words[] = s1.split(" ");
        String sen2Words[] = s2.split(" ");
        for(var word : sen1Words){
            wordFreq1.put(word, wordFreq1.getOrDefault(word, 0)+1);
        }
        for(var word : sen2Words){
            wordFreq2.put(word, wordFreq2.getOrDefault(word, 0)+1);
        }
        List<String> uncommons = new ArrayList<>();
        
        for(var entry : wordFreq1.entrySet()){
            String word = entry.getKey();
            int wordFreq = entry.getValue();
            if(wordFreq == 1 && !wordFreq2.containsKey(word)){
                 uncommons.add(word);
            }
        }
       
        for(var entry : wordFreq2.entrySet()){
            String word = entry.getKey();
            int wordFreq = entry.getValue();
            if(wordFreq == 1 && !wordFreq1.containsKey(word)){
                 uncommons.add(word);
            }
        }
        return uncommons.stream().toArray(String[]::new);
    }
}
