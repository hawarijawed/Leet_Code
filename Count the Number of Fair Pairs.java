/*
Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.

A pair (i, j) is fair if:

0 <= i < j < n, and
lower <= nums[i] + nums[j] <= upper
*/
import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] v, int lower, int upper) {
        Arrays.sort(v);
        long ans = 0;
        for (int i = 0; i < v.length - 1; i++) {
            int low = lowerBound(v, i + 1, v.length, lower - v[i]);
            int up = upperBound(v, i + 1, v.length, upper - v[i]);
            ans += up - low;
        }
        return ans;
    }
  
    private int lowerBound(int[] v, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (v[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    private int upperBound(int[] v, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (v[mid] > target) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}
