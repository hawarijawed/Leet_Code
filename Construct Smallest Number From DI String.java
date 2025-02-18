/*
You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.

A 0-indexed string num of length n + 1 is created using the following conditions:

num consists of the digits '1' to '9', where each digit is used at most once.
If pattern[i] == 'I', then num[i] < num[i + 1].
If pattern[i] == 'D', then num[i] > num[i + 1].
Return the lexicographically smallest possible string num that meets the conditions.
*/
class Solution {

    public String smallestNumber(String pattern) {
        return String.valueOf(findSmallestNumber(pattern, 0, 0, 0));
    }

    // Recursively find the smallest number that satisfies the pattern
    private int findSmallestNumber(
        String pattern,
        int currentPosition,
        int usedDigitsMask,
        int currentNum
    ) {
        // Base case: return the current number when the whole pattern is processed
        if (currentPosition > pattern.length()) return currentNum;

        int result = Integer.MAX_VALUE;
        int lastDigit = currentNum % 10;
        boolean shouldIncrement =
            currentPosition == 0 || pattern.charAt(currentPosition - 1) == 'I';

        // Try all possible digits (1 to 9) that are not yet used and follow the pattern
        for (int currentDigit = 1; currentDigit <= 9; ++currentDigit) {
            if (
                (usedDigitsMask & (1 << currentDigit)) == 0 &&
                currentDigit > lastDigit == shouldIncrement
            ) result = Math.min(
                result,
                findSmallestNumber(
                    pattern,
                    currentPosition + 1,
                    usedDigitsMask | (1 << currentDigit),
                    currentNum * 10 + currentDigit
                )
            );
        }

        return result;
    }
}
