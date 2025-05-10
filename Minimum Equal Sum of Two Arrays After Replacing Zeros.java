/*
You are given two arrays nums1 and nums2 consisting of positive integers.

You have to replace all the 0's in both arrays with strictly positive integers such that the sum of elements of both arrays becomes equal.

Return the minimum equal sum you can obtain, or -1 if it is impossible.
*/
class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        long sum1 = 0, sum2 = 0;
        int c1 = 0, c2 = 0;
        for(int i=0; i<n1; i++){
            sum1 += nums1[i];
            if(nums1[i] == 0){
                c1++;
            }
        }
        for(int i=0; i<n2; i++){
            sum2 += nums2[i];
            if(nums2[i] == 0){
                c2++;
            }
        }

        long minSum1 = sum1 + c1*1;
        long minSum2 = sum2 + c2*1;

        if(c1 == 0 && minSum2 > minSum1 || c2 == 0 && minSum1 > minSum2){
            return -1;
        }
        return Math.max(minSum1, minSum2);
    }
}
