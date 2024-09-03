/*
You are given a string s consisting of lowercase English letters, and an integer k.

First, convert s into an integer by replacing each letter with its position in the alphabet (i.e., replace 'a' with 1, 'b' with 2, ..., 'z' with 26). 
Then, transform the integer by replacing it with the sum of its digits. Repeat the transform operation k times in total.
Return the resulting integer after performing the operations described above.
*/
class Solution {
    public int getLucky(String s, int k) {
        String str = "";
        //Converting alphabets with its corresponding positions
        for(char ch: s.toCharArray()){
            int num = ch - 96;
            String temp = Integer.toString(num);
            str += temp;
        }

        int res = 0;
        //Performing first transformation
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            //converting character into integer
            int num = ch-'0';
            //Adding the character into res
            res += num;
        }

        //For first transformation
        if(k==1){
            return res;
        }

        
        while (k > 1) {
            int tempSum = 0;
            while (res > 0) {
                tempSum += res % 10;
                res /= 10;
            }
            res = tempSum;
            k--;
        }
        return res;
    }
}
