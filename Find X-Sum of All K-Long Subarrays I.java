/*
You are given an array nums of n integers and two integers k and x.

The x-sum of an array is calculated by the following procedure:

Count the occurrences of all elements in the array.
Keep only the occurrences of the top x most frequent elements. If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.
Calculate the sum of the resulting array.
Note that if an array has less than x distinct elements, its x-sum is the sum of the array.

Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the subarray nums[i..i + k - 1].
*/
class Solution {

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; ++i) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int j = i; j < i + k; ++j) {
                cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
            }

            List<int[]> freq = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                freq.add(new int[] { entry.getValue(), entry.getKey() });
            }

            freq.sort((a, b) -> b[0] != a[0] ? b[0] - a[0] : b[1] - a[1]);
            int xsum = 0;
            for (int j = 0; j < x && j < freq.size(); ++j) {
                xsum += freq.get(j)[0] * freq.get(j)[1];
            }
            ans[i] = xsum;
        }

        return ans;
    }
}
