/*
You are given an integer array nums of size n.
Consider a non-empty subarray from nums that has the maximum possible bitwise AND.
In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered.
Return the length of the longest such subarray.
The bitwise AND of an array is the bitwise AND of all the numbers in it.
A subarray is a contiguous sequence of elements within an array.
*/
//---------------------------------Approach 1: Using Maximum element ----------------------------------//
class Solution {
    public int longestSubarray(int[] nums) {
        int size = nums.length;
        int len = 0;
        int max = nums[0];
        for(int i=1; i<size; i++){
            max = Math.max(max, nums[i]);
        }

        //find the consecutive of max
        int temp = 0;
        for(int i=0; i<size; i++){
            if(nums[i] == max){
                temp++;
            }
            else{
                temp = 0;
            }
            len = Math.max(len, temp);
        }
        return len;
       
    }
}

//---------------------------------Approach 2: Using one loop ----------------------------------//
class Solution {
    public int longestSubarray(int[] nums) {
        
        int len =0, size= 0;
        int cur_max = 0;
        //Possible cases
        //1. if n<cur_max, n & cur_max<cur_max
        //2. if n==cur_max, n & cur_max = cur_max
        //3. if n>cur_max, n & cur_max < cur_max

        for(int a: nums){
            if(a>cur_max){
                cur_max = a;
                size = 1;
                len = 0;
            }
            else if(a == cur_max){
                size++;
            }
            else{
                size = 0;
            }

            len = Math.max(len, size);
        }
        return len;
       
    }
}
