/*
You have two soups, A and B, each starting with n mL. On every turn, one of the following four serving operations is chosen at random, each with probability 0.25 independent of all previous turns:

pour 100 mL from type A and 0 mL from type B
pour 75 mL from type A and 25 mL from type B
pour 50 mL from type A and 50 mL from type B
pour 25 mL from type A and 75 mL from type B
Note:

There is no operation that pours 0 mL from A and 100 mL from B.
The amounts from A and B are poured simultaneously during the turn.
If an operation asks you to pour more than you have left of a soup, pour all that remains of that soup.
The process stops immediately after any turn in which one of the soups is used up.

Return the probability that A is used up before B, plus half the probability that both soups are used up in the same turn. Answers within 10-5 of the actual answer will be accepted.
*/

class Solution {
    public double soupServings(int n) {
        int m = (int)Math.ceil(n / 25.0);
        Map<Integer, Map<Integer, Double>> dp = new HashMap<>();
        dp.put(0, new HashMap<>());
        dp.get(0).put(0, 0.5);

        for (int k = 1; k <= m; k++) {
            dp.put(k, new HashMap<>());
            dp.get(0).put(k, 1.0);
            dp.get(k).put(0, 0.0);
            for (int j = 1; j <= k; j++) {
                dp.get(j).put(k, calculateDP(j, k, dp));
                dp.get(k).put(j, calculateDP(k, j, dp));
            }
            if (dp.get(k).get(k) > 1 - 1e-5) {
                return 1;
            }
        }

        return dp.get(m).get(m);
    }

    private double calculateDP(int i, int j, Map<Integer, Map<Integer, Double>> dp) {
        return (dp.get(Math.max(0, i - 4)).get(j)
                + dp.get(Math.max(0, i - 3)).get(j - 1)
                + dp.get(Math.max(0, i - 2)).get(Math.max(0, j - 2))
                + dp.get(i - 1).get(Math.max(0, j - 3))) / 4;
    }
}
