/*
Given the string s, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.
*/

class Solution {
    public int findTheLongestSubstring(String s) {
        //map(bit mask, index)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int maxLen = 0;
        int bit_mask = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == 'a'){
                bit_mask = bit_mask^1<<0;
            }
            if(ch == 'e'){
                bit_mask = bit_mask^1<<1;
            }
            if(ch == 'i'){
                bit_mask = bit_mask^1<<2;
            }
            if(ch == 'o'){
                bit_mask = bit_mask^1<<3;
            }
            if(ch == 'u'){
                bit_mask = bit_mask^1<<4;
            }

            //Check whether bit_mask exist in map or not;
            if(map.containsKey(bit_mask)){
                //Access the previous index
                int prevIndex = map.get(bit_mask);
                maxLen = Math.max(maxLen, i - prevIndex);
            }
            else{
                //Put it into map
                map.put(bit_mask, i);
            }

        }
        return maxLen;

    }
}
