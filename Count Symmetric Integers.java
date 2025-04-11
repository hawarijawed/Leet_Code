/*
You are given two positive integers low and high.

An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.

Return the number of symmetric integers in the range [low, high].
*/
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i=low; i<=high; i++){
            String st = Integer.toString(i);
            int n = st.length();
            if(n%2 == 0){
                int s1 = 0;
                int s2 = 0;
                for(int j=0; j<n/2; j++){
                    s1 += st.charAt(j)-0;
                }
                for(int j=n/2; j<n; j++){
                    s2 += st.charAt(j)-0;
                }
                if(s1 == s2){
                    count++;
                }
            }
        }

        return count;
    }
}
