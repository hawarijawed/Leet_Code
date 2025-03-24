/*
You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

Return the count of days when the employee is available for work but no meetings are scheduled.

Note: The meetings may overlap.
*/
class Solution {

    public int countDays(int days, int[][] meetings) {
        int freeDays = 0, latestEnd = 0;

        // Sort meetings based on starting times
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int n=meetings.length;
        for(int i=0; i<n; i++){
            int start = meetings[i][0];
            if(start > (latestEnd + 1)){
                freeDays += start - latestEnd -1;
            }
            latestEnd = Math.max(meetings[i][1], latestEnd);
        }

        freeDays += days - latestEnd;
        return freeDays;
    }
}
