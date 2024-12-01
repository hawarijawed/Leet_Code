/*
Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
*/
//------------------------ Approach 01: Using HashMap Time: O(N), Space: O(N) -------------------------//
class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            map.put(arr[i], i);
        }
        for(int i=0; i<n; i++){
            if(arr[i] %2 == 0){
                int val = arr[i]/2;
                if(map.containsKey(val) && map.get(val) != i){
                    return true;
                }
            }
        }
        return false;
    }
}
//------------------------ Approach 01: Using HashSet Time: O(N), Space: O(N) -------------------------//
class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            // Check if either num*2 or num/2 is in the set
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
