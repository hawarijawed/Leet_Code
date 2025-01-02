/*
You are given a 0-indexed array of strings words and a 2D array of integers queries.

Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive) of words that start and end with a vowel.

Return an array ans of size queries.length, where ans[i] is the answer to the ith query.

Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.
*/
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int n = words.length;
        int [] pref = new int[n]; //prefix sum array
        int prefixSum = 0;
        for(int i=0; i<n; i++){
            String st = words[i];
            int len = st.length();
            if(set.contains(st.charAt(0)) && set.contains(st.charAt(len-1))){
                prefixSum++;
            }
            pref[i] = prefixSum;
        }

        int m = queries.length;
        int [] res = new int[m];
        for(int i=0; i<m; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if(l==0){
                res[i] = pref[r];
            }
            else{
                res[i] = pref[r] - pref[l-1];
            }
        }

        return res;
    }
}
