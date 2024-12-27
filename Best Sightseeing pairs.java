/*
You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.
*/
class Solution {

    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        // Initialize an array to store the maximum left scores up to each index.
        int[] maxLeftScore = new int[n];
        // The left score at the first index is just the value of the first element.
        maxLeftScore[0] = values[0];

        int maxScore = 0;

        for (int i = 1; i < n; i++) {
            int currentRightScore = values[i] - i;
            // Update the maximum score by combining the best left score so far with the current right score.
            maxScore = Math.max(
                maxScore,
                maxLeftScore[i - 1] + currentRightScore
            );

            int currentLeftScore = values[i] + i;
            // Update the maximum left score up to the current index.
            maxLeftScore[i] = Math.max(maxLeftScore[i - 1], currentLeftScore);
        }

        return maxScore;
    }
}
