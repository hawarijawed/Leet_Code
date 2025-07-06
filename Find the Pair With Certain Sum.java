/*
You are given two integer arrays nums1 and nums2. You are tasked to implement a data structure that supports queries of two types:

Add a positive integer to an element of a given index in the array nums2.
Count the number of pairs (i, j) such that nums1[i] + nums2[j] equals a given value (0 <= i < nums1.length and 0 <= j < nums2.length).
Implement the FindSumPairs class:

FindSumPairs(int[] nums1, int[] nums2) Initializes the FindSumPairs object with two integer arrays nums1 and nums2.
void add(int index, int val) Adds val to nums2[index], i.e., apply nums2[index] += val.
int count(int tot) Returns the number of pairs (i, j) such that nums1[i] + nums2[j] == tot.
*/

import java.util.*;

class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> freqMap;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        freqMap = new HashMap<>();
        for (int num : nums2) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        if (index >= 0 && index < nums2.length) {
            int oldVal = nums2[index];
            int newVal = oldVal + val;

            // Update frequency map
            freqMap.put(oldVal, freqMap.get(oldVal) - 1);
            if (freqMap.get(oldVal) == 0) {
                freqMap.remove(oldVal);
            }
            freqMap.put(newVal, freqMap.getOrDefault(newVal, 0) + 1);

            nums2[index] = newVal;
        }
    }

    public int count(int tot) {
        int count = 0;
        for (int num : nums1) {
            int complement = tot - num;
            count += freqMap.getOrDefault(complement, 0);
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
