/*
No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.

Given an integer n, return a list of two integers [a, b] where:

a and b are No-Zero integers.
a + b = n
The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.
*/
class Solution {
    public int[] getNoZeroIntegers(int n) {
        if(n==2){
            return new int[]{1,1};
        }

        int a = 0;
        int b = 0;
        for(int i=2; i<=n; i++){
            a = i;
            b = n-i;
            if(noZero(a) && noZero(b)){
                break;
            }
        }
        return new int[]{a,b};
    }

    public boolean noZero(int n){
        while(n>0){
            if(n%10 == 0){
                return false;
            }
            n = n/10;
        }
        return true;
    }
}
