/*
The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.

*/
class Solution {
    public int findComplement(int num) {
        //To calculate binary length of a number
        // logN+1

        int digits = (int)(Math.log(num)/Math.log(2) + 1);
        int bitMask = 1<<digits;

        return (num^(bitMask-1));
    }
}
