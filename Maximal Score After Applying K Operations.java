/*
You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.

In one operation:
1. choose an index i such that 0 <= i < nums.length,
2. increase your score by nums[i], and
3. replace nums[i] with ceil(nums[i] / 3).
Return the maximum possible score you can attain after applying exactly k operations.

The ceiling function ceil(val) is the least integer greater than or equal to val.
*/
class Solution {
    public long maxKelements(int[] nums, int k) {
    PriorityQueue<Integer>pq = new PriorityQueue<>((a, b)->b-a);
    for(int x : nums)
    pq.offer(x);
    long score = 0; 
    while(!pq.isEmpty() && k>0)
    {
      score +=pq.peek();
      int x = (int)Math.ceil(pq.poll()/3.0);
      pq.add(x);
      k--;
    }
     return score;
    }
}
