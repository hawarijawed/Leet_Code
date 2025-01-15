/*
Given two positive integers num1 and num2, find the positive integer x such that:

x has the same number of set bits as num2, and
The value x XOR num1 is minimal.
Note that XOR is the bitwise XOR operation.

Return the integer x. The test cases are generated such that x is uniquely determined.

The number of set bits of an integer is the number of 1's in its binary representation.
*/
class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBits = Integer.bitCount(num2);
        int bit = 31;
        int res=0;
        while(bit >=0 && setBits>0){
            if((num1 & (1<<bit)) != 0){
                res = res| (1<<bit);
                setBits--;
            }
            bit--;
        }

        bit = 0;
        while(setBits>0 && bit<=32){
            if((num1 & (1<<bit)) == 0){
                res = res| (1<<bit);
                setBits--;
            }
            bit++;
        }

        return res;
    }
}
