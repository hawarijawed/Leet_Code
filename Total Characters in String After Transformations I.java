/*
You are given a string s and an integer t, representing the number of transformations to perform. In one transformation, every character in s is replaced according to the following rules:

If the character is 'z', replace it with the string "ab".
Otherwise, replace it with the next character in the alphabet. For example, 'a' is replaced with 'b', 'b' is replaced with 'c', and so on.
Return the length of the resulting string after exactly t transformations.

Since the answer may be very large, return it modulo 109 + 7.
*/

//Brute force and Optimal approach

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        
        HashMap<Character, Character> map = new HashMap<>();
        for(char ch = 'a'; ch<'z'; ch++){
            char nxt = ch;
            nxt++;
            map.put(ch, nxt);
        }
        
        for(int j = 0; j<t; j++){
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++){
                char ch = s.charAt(i);
                if(ch == 'z'){
                    sb.append('a');
                    sb.append('b');
                    continue;
                }
                sb.append(map.get(ch));
            }

            s = sb.toString();
        }
        return s.length();
    }

    private static final int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            ++cnt[ch - 'a'];
        }
        for (int round = 0; round < t; ++round) {
            int[] nxt = new int[26];
            nxt[0] = cnt[25];
            nxt[1] = (cnt[25] + cnt[0]) % MOD;
            for (int i = 2; i < 26; ++i) {
                nxt[i] = cnt[i - 1];
            }
            cnt = nxt;
        }
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans = (ans + cnt[i]) % MOD;
        }
        return ans;
    }
}

