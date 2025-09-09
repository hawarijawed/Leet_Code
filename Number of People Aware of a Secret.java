/*
On day 1, one person discovers a secret.

You are given an integer delay, which means that each person will share the secret with a new person every day, starting from delay days after discovering the secret. You are also given an integer forget, which means that each person will forget the secret forget days after discovering it. A person cannot share the secret on the same day they forgot it, or on any day afterwards.

Given an integer n, return the number of people who know the secret at the end of day n. Since the answer may be very large, return it modulo 109 + 7.
*/
class Solution {

    private static final int MOD = 1000000007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        Deque<int[]> know = new LinkedList<>();
        Deque<int[]> share = new LinkedList<>();
        know.add(new int[] { 1, 1 });
        int knowCnt = 1;
        int shareCnt = 0;

        for (int i = 2; i <= n; i++) {
            if (!know.isEmpty() && know.peekFirst()[0] == i - delay) {
                int[] first = know.pollFirst();
                knowCnt = (knowCnt - first[1] + MOD) % MOD;
                shareCnt = (shareCnt + first[1]) % MOD;
                share.add(first);
            }
            if (!share.isEmpty() && share.peekFirst()[0] == i - forget) {
                int[] first = share.pollFirst();
                shareCnt = (shareCnt - first[1] + MOD) % MOD;
            }
            if (!share.isEmpty()) {
                knowCnt = (knowCnt + shareCnt) % MOD;
                know.add(new int[] { i, shareCnt });
            }
        }
        return (knowCnt + shareCnt) % MOD;
    }
}
