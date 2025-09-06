/*
You are given a 2D array queries, where queries[i] is of the form [l, r]. Each queries[i] defines an array of integers nums consisting of elements ranging from l to r, both inclusive.

In one operation, you can:

Select two integers a and b from the array.
Replace them with floor(a / 4) and floor(b / 4).
Your task is to determine the minimum number of operations required to reduce all elements of the array to zero for each query. Return the sum of the results for all queries.
*/
class Solution {

    private long get(int num) {
        long cnt = 0;
        int i = 1;
        int base = 1;
        while (base <= num) {
            int end = Math.min(base * 2 - 1, num);
            cnt += (long) ((i + 1) / 2) * (end - base + 1);
            i++;
            base *= 2;
        }
        return cnt;
    }

    public long minOperations(int[][] queries) {
        long res = 0;
        for (int[] q : queries) {
            long count1 = get(q[1]);
            long count2 = get(q[0] - 1);
            res += (count1 - count2 + 1) / 2;
        }
        return res;
    }
}
