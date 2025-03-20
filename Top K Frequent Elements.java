/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        if(len==1) return nums;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(entry);
        }
        int []res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
