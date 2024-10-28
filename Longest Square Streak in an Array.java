/*
You are given an integer array nums. A subsequence of nums is called a square streak if:

The length of the subsequence is at least 2, and
after sorting the subsequence, each element (except the first element) is the square of the previous number.
Return the length of the longest square streak in nums, or return -1 if there is no square streak.
*/
class Solution {
    public int longestSquareStreak(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int a: nums){
            set.add(a);
        }
        List<Integer> setArr = new ArrayList<>(set);
        Collections.sort(setArr);
        int max = -1;
        for (int i = 0; i < setArr.size(); i++) {
            int curr = setArr.get(i);
            int count = 0;
            
            while (set.contains(curr)) {
                set.remove(curr);
                curr = curr * curr;
                count++;
            }
            
            max = Math.max(max, count);
        }
        
        return max > 1 ? max : -1;
    }
}
