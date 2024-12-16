/*
You are given an integer array nums, an integer k, and an integer multiplier.

You need to perform k operations on nums. In each operation:

Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
Replace the selected minimum value x with x * multiplier.
Return an integer array denoting the final state of nums after performing all k operations.
*/
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) ->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0]-b[0];
        });

        for(int i=0; i<nums.length; i++){
            pq.offer(new int[] {nums[i], i});
        }

        //Perform K operations
        for(int i=0; i<k; i++){
            int arr[] = pq.poll();
            nums[arr[1]] = nums[arr[1]] * multiplier;
            pq.offer(new int[]{nums[arr[1]], arr[1]});
        }

        return nums;
    }
}
