/*
You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.
*/
class Solution {    

    public int maximumSwap(int num) {
        
        char[] digits = Integer.toString(num).toCharArray();
        int[] last = new int[10]; // Track the last occurrence of each digit

        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    // Found a larger digit to swap
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    return Integer.parseInt(new String(digits)); // Return immediately after swap
                }
            }
        }
    
        return num; // If no swap is possible, return original number

    }
}
