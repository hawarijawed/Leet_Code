/*
You are given a 0-indexed integer array nums, and an integer k.

In one operation, you will:

Take the two smallest integers x and y in nums.
Remove x and y from nums.
Add min(x, y) * 2 + max(x, y) anywhere in the array.
Note that you can only apply the described operation if nums contains at least two elements.

Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.
*/
class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            pq.offer((long)nums[i]);
        }

        int steps = 0;
        while(pq.size()>=2 && !(pq.peek() >= k)){
            long x = pq.poll();
            long y = pq.poll();
            long z = Math.min(x, y)*2 + Math.max(x, y);
            pq.offer(z);
            steps++;
        }

        return steps;
    }
}
