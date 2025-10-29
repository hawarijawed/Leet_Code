/*
You are given a positive number n.

Return the smallest number x greater than or equal to n, such that the binary representation of x contains only set bits
*/
class Solution {
    public int smallestNumber(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<binary.length(); i++){
            sb.append('1');
        }

        String st = sb.toString();
        return Integer.parseInt(st , 2);
    }
}
