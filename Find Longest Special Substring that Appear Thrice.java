/*
You are given a string s that consists of lowercase English letters.

A string is called special if it is made up of only a single character. For example, the string "abc" is not special, whereas the strings "ddd", "zz", and "f" are special.

Return the length of the longest special substring of s which occurs at least thrice, or -1 if no special substring occurs at least thrice.

A substring is a contiguous non-empty sequence of characters within a string.
*/
class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = s.length();

        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<n; j++){
                if(sb.length() == 0 || s.charAt(j) == sb.charAt(sb.length()-1)){
                    sb.append(s.charAt(j));
                    String curr = sb.toString();
                    map.put(curr, map.getOrDefault(curr, 0)+1);
                }
                else{
                    break;
                }
            }
        }

        int maxLen = -1;
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            String st = entry.getKey();
            int count = entry.getValue();
            if(count >= 3){
                maxLen = Math.max(maxLen, st.length());
            }
        }

        return maxLen;
    }
}
