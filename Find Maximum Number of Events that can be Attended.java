/*
You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

Return the maximum number of events you can attend.
*/

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i = 0, res = 0, day = 1;
        int n = events.length;
        
        // Find max day to iterate up to
        int maxDay = 0;
        for (int[] e : events) {
            maxDay = Math.max(maxDay, e[1]);
        }

        while (day <= maxDay) {
            // Add all events starting today
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            // Remove events that have expired
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            // Attend one event with earliest end day
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }

            day++;
        }

        return res;
    }
}
