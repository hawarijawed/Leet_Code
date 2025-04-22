/*
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1]-b[1]));
        int res = 0;
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(end <= intervals[i][0]){
                end = intervals[i][1];
            }
            else{
                res++;
            }
        }

        return res;
    }
}
