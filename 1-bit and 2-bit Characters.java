/*
We have two special characters:

1. The first character can be represented by one bit 0.
2. The second character can be represented by two bits (10 or 11).
Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.
*/
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        //if(n%2 != 0) return true;
        
        int i=0;
        while(i < n){
            if(bits[i] == 1){
                i += 2;
                if(i == n) return false;
            }
            else{
                i++;
            }
        }
        return true;
    }
}
