/*
You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.

You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.

Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.
*/
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            int idx = bs(potions, spells[i], success);
            if (idx != -1) ans[i] = potions.length - idx;
        }

        return ans;
    }

    int bs(int potions[], long strength, long success) {
        int low = 0, high = potions.length - 1, idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) potions[mid] * strength >= success) {
                idx = mid;
                high = mid - 1; // find smaller index
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }
}
