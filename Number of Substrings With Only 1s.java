/*
Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.
*/

class Solution {
    public int numSub(String s) {
        long mod = 1000000007;
        long count = 0;
        long result = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            } else {
                result = (result + count * (count + 1) / 2) % mod;
                count = 0;
            }
        }

        // Add last segment
        result = (result + count * (count + 1) / 2) % mod;

        return (int) result;
    }
}
