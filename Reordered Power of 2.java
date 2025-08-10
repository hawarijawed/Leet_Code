/*
You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.
*/

import java.util.*;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = countDigits(n);

        for (int i = 0; i < 31; i++) {
            int power = 1 << i;
            if (target.equals(countDigits(power))) {
                return true;
            }
        }

        return false;
    }

    private String countDigits(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        Arrays.sort(digits);  // digit signature
        return new String(digits);
    }
}
