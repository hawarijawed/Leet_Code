/*
You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].
You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no two intervals that are in the same group intersect each other.
Return the minimum number of groups you need to make.

Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.
*/
class Solution {
    public int minGroups(int[][] intervals) {
        //Sorting the inteval based on arrival
        Arrays.sort(intervals, (a,b) ->Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int [] interval: intervals){
            if(!minHeap.isEmpty() && interval[0] > minHeap.peek()){
                minHeap.poll();
            }
            minHeap.offer(interval[1]);
        }
        return minHeap.size();
    }
}
