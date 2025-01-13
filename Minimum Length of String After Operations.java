/*
You are given a string s.

You can perform the following process on s any number of times:

Choose an index i in the string such that there is at least one character to the left of index i that is equal to s[i], and at least one character to the right that is also equal to s[i].
Delete the closest character to the left of index i that is equal to s[i].
Delete the closest character to the right of index i that is equal to s[i].
Return the minimum length of the final string s that you can achieve.
*/
class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int [] freq = new int[26];
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        int count = 0;
        for(int i=0; i<26; i++){
            if(freq[i] > 0){
                //If even frequency
                if(freq[i]%2 == 0){
                    count+=2;
                }
                else{
                    count += 1;
                }
            }
        }

        return count;
    }
}
