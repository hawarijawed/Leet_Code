/*
There is a party where n friends numbered from 0 to n - 1 are attending. There is an infinite number of chairs in this party that are numbered from 0 to infinity. When a friend arrives at the party, they sit on the unoccupied chair with the smallest number.

For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
When a friend leaves the party, their chair becomes unoccupied at the moment they leave. If another friend arrives at that same moment, they can sit in that chair.

You are given a 0-indexed 2D integer array times where times[i] = [arrivali, leavingi], indicating the arrival and leaving times of the ith friend respectively, and an integer targetFriend. All arrival times are distinct.

Return the chair number that the friend numbered targetFriend will sit on.
*/
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
         // Step 1: Create events
        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            events.add(new int[]{times[i][0], i, 1});  // arrival event
            events.add(new int[]{times[i][1], i, -1}); // departure event
        }
        
        // Step 2: Sort events first by time, then by type (departure before arrival)
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[2], b[2]); // prioritize departure
        });

        // Step 3: Use a PriorityQueue (Min-Heap) for available chairs
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        int[] chairAssignments = new int[times.length];
        int nextChair = 0;

        // Step 4: Process events
        for (int[] event : events) {
            int time = event[0];
            int friendIndex = event[1];
            int type = event[2];

            // Handle departure
            if (type == -1) {
                // Return chair when a friend leaves
                int chair = chairAssignments[friendIndex];
                availableChairs.offer(chair);
            } else { // Handle arrival
                int chairToSit;
                if (!availableChairs.isEmpty()) {
                    chairToSit = availableChairs.poll(); // get the smallest available chair
                } else {
                    chairToSit = nextChair++; // use the next chair number
                }
                chairAssignments[friendIndex] = chairToSit; // assign chair
                // If this is the target friend, return the chair number
                if (friendIndex == targetFriend) {
                    return chairToSit;
                }
            }
        }

        return -1; // Should not reach here if inputs are valid
    }
}
