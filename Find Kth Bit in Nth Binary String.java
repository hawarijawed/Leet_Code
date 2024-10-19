/*
Given two positive integers n and k, the binary string Sn is formed as follows:

S1 = "0"
Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).

For example, the first four strings in the above sequence are:

S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
Return the kth bit in Sn. It is guaranteed that k is valid for the given n.
*/
class Solution {
    private char findKth(int n, int k, int len) {
        // Base case
        if (n == 1) {
            return '0'; // S1 = "0"
        }

        int mid = (len + 1) / 2; // Middle index in Sn

        if (k < mid) {
            // k is in the first half
            return findKth(n - 1, k, (1 << (n - 1)) - 1);
        } else if (k == mid) {
            // k is the middle element
            return '1';
        } else {
            // k is in the second half
            int newK = len - k + 1; // Position in the reversed and inverted part
            char bit = findKth(n - 1, newK, (1 << (n - 1)) - 1);
            return bit == '0' ? '1' : '0'; // Invert the bit
        }
    }
    public char findKthBit(int n, int k) {
        // Calculate the length of Sn
        int len = (1 << n) - 1; // This is 2^n - 1

        return findKth(n, k, len);
    }
}
