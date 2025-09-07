/*
Given an integer n, return any array containing n unique integers such that they add up to 0.
*/

class Solution {
    public int[] sumZero(int n) {
        if(n==1) return new int[]{0};
        int [] res = new int[n];
        int i=0;
        int st = 1;
        if(n%2 == 1){
            res[i++] = 0;
        }
        while(i <n){
            res[i++] = st;
            res[i++] = -st;
            st++;
        }
        return res;
    }

}
