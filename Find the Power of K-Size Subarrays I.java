/*
You are given an array of integers nums of length n and a positive integer k.

The power of an array is defined as:

Its maximum element if all of its elements are consecutive and sorted in ascending order.
-1 otherwise.
You need to find the power of all 
subarrays
 of nums of size k.

Return an integer array results of size n - k + 1, where results[i] is the power of nums[i..(i + k - 1)].
*/
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        
        if(n == 1) return nums;

        int size = n - k + 1; //Size of new array
        int left = 0;
        int right = k - 1;
        int []arr = new int[size];
        int count=0; //keeps track of index for new array arr
        boolean flag = true;
        while(right < n){
            for(int i=left; i<right; i++){
                if(nums[i] + 1 != nums[i+1]){
                    flag = false;
                    break;
                }
            }

            if(flag){
                arr[count++] = nums[right];
                
            }
            else{
                arr[count++] = -1;
            }
            left++;
            right++;
            flag = true;// setting to true for next subarray
        }

        return arr;
    }
}
