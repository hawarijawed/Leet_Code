/*
You are given two 2D integer arrays nums1 and nums2.

nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
Each array contains unique ids and is sorted in ascending order by id.

Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

Only ids that appear in at least one of the two arrays should be included in the resulting array.
Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
Return the resulting array. The returned array must be sorted in ascending order by id.
*/
class Solution {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int N1 = nums1.length, N2 = nums2.length;
        int ptr1 = 0, ptr2 = 0;

        List<int[]> mergedArray = new ArrayList<>();
        while (ptr1 < N1 && ptr2 < N2) {
            // If the id is same, add the values and insert to the result.
            // Increment both pointers.
            if (nums1[ptr1][0] == nums2[ptr2][0]) {
                mergedArray.add(
                    new int[] {
                        nums1[ptr1][0],
                        nums1[ptr1][1] + nums2[ptr2][1],
                    }
                );
                ptr1++;
                ptr2++;
            } else if (nums1[ptr1][0] < nums2[ptr2][0]) {
                // If the id in nums1 is smaller, add it to result and increment the pointer
                mergedArray.add(nums1[ptr1]);
                ptr1++;
            } else {
                // If the id in nums2 is smaller, add it to result and increment the pointer
                mergedArray.add(nums2[ptr2]);
                ptr2++;
            }
        }

        // If pairs are remaining in the nums1, then add them to the result.
        while (ptr1 < N1) {
            mergedArray.add(nums1[ptr1]);
            ptr1++;
        }

        // If pairs are remaining in the nums2, then add them to the result.
        while (ptr2 < N2) {
            mergedArray.add(nums2[ptr2]);
            ptr2++;
        }

        // Convert List<int[]> to int[][]
        int[][] result = new int[mergedArray.size()][2];
        for (int i = 0; i < mergedArray.size(); i++) {
            result[i] = mergedArray.get(i);
        }

        return result;
    }
}
