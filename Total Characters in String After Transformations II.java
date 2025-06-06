/*
You are given a string s consisting of lowercase English letters, an integer t representing the number of transformations to perform, and an array nums of size 26. In one transformation, every character in s is replaced according to the following rules:

Replace s[i] with the next nums[s[i] - 'a'] consecutive characters in the alphabet. For example, if s[i] = 'a' and nums[0] = 3, the character 'a' transforms into the next 3 consecutive characters ahead of it, which results in "bcd".
The transformation wraps around the alphabet if it exceeds 'z'. For example, if s[i] = 'y' and nums[24] = 3, the character 'y' transforms into the next 3 consecutive characters ahead of it, which results in "zab".
Return the length of the resulting string after exactly t transformations.

Since the answer may be very large, return it modulo 109 + 7.
*/

class Solution {

    private static final int MOD = (int) 1e9 + 7;
    private static final int L = 26;

    private static class Mat {

        int[][] a = new int[L][L];

        Mat() {}

        Mat(Mat copyFrom) {
            for (int i = 0; i < L; i++) {
                System.arraycopy(copyFrom.a[i], 0, this.a[i], 0, L);
            }
        }

        Mat mul(Mat other) {
            Mat result = new Mat();
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < L; j++) {
                    for (int k = 0; k < L; k++) {
                        result.a[i][j] = (int) ((result.a[i][j] +
                                (long) this.a[i][k] * other.a[k][j]) %
                            MOD);
                    }
                }
            }
            return result;
        }
    }

    /* identity matrix */
    private Mat I() {
        Mat m = new Mat();
        for (int i = 0; i < L; i++) {
            m.a[i][i] = 1;
        }
        return m;
    }

    /* matrix exponentiation by squaring */
    private Mat quickmul(Mat x, int y) {
        Mat ans = I();
        Mat cur = new Mat(x);
        while (y > 0) {
            if ((y & 1) == 1) {
                ans = ans.mul(cur);
            }
            cur = cur.mul(cur);
            y >>= 1;
        }
        return ans;
    }

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        Mat T = new Mat();
        for (int i = 0; i < L; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                T.a[(i + j) % L][i] = 1;
            }
        }

        Mat res = quickmul(T, t);
        int[] f = new int[L];
        for (char ch : s.toCharArray()) {
            f[ch - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                ans = (int) ((ans + (long) res.a[i][j] * f[j]) % MOD);
            }
        }
        return ans;
    }
}
