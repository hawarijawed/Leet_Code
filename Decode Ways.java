/*
You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:

"1" -> 'A'

"2" -> 'B'

...

"25" -> 'Y'

"26" -> 'Z'

However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").

For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.

The test cases are generated so that the answer fits in a 32-bit integer.
*/


class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        
        // dp[i] means the number of ways to decode the string up to index i-1
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: one way to decode an empty string
        dp[1] = (s.charAt(0) != '0') ? 1 : 0; // Base case: 1 way to decode the first character (if valid)

        for (int i = 2; i <= n; i++) {
            // Check for a valid single digit
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // Check for a valid two-digit number
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
 
