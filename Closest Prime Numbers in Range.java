/*
Given two positive integers left and right, find the two integers num1 and num2 such that:

left <= num1 < num2 <= right .
Both num1 and num2 are prime numbers.
num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].
*/
class Solution {
    public boolean isPrime(int num){
        if(num <= 1) return false;

        for(int i=2; i*i <= num; i++){
            if(num%i == 0){
                return false;
            }
        }

        return true;
    }
    public int[] closestPrimes(int left, int right) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int count = 0;
        int prev = -1;
        int minDiff = Integer.MAX_VALUE;
        for(int i=left; i<=right; i++){
            if(isPrime(i)){
                if(prev==-1){
                    prev = i;
                    //res[0] = prev;
                    continue;
                }
                if(i-prev < minDiff){
                    minDiff = i-prev;
                    res[0] = prev;
                    res[1] = i;
                }
                prev = i;
            }
            
        }

        return res;
    }
}


--------------------------------------------------------------------------------------------------------------------------------------------
class Solution {
    
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = new boolean[right + 1];
        Arrays.fill(prime, true);
        prime[0] = false;//referse to 0
        prime[1] = false;// refers to 1

        for(int p = 2; p*p <= right; p++){
            if(prime[p]){
                for(int i=p*p; i<=right; i+=p){
                    prime[i] = false;
                }
            }
        }

        int[]res = new int[]{-1, -1};
        int prev = -1;
        int minDiff = Integer.MAX_VALUE;
        for(int i=left; i<=right; i++){
            if(prime[i]){
                if(prev == -1){
                    prev = i;
                }
                else{
                    if(i - prev < minDiff){
                        res[0] = prev;
                        res[1] = i;
                        minDiff = i - prev;
                    }

                    prev = i;
                }
            }
        }

        return res;
    }
}
