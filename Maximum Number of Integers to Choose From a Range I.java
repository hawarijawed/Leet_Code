/*
You are given an integer array banned and two integers n and maxSum. You are choosing some number of integers following the below rules:

The chosen integers have to be in the range [1, n].
Each integer can be chosen at most once.
The chosen integers should not be in the array banned.
The sum of the chosen integers should not exceed maxSum.
Return the maximum number of integers you can choose following the mentioned rules.
*/
//--------------------------- Approach: 01 --------------------------//
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for(int val: banned){
            set.add(val);
        }
        int sum = 0, count = 0;
        for(int i=1; i<=n; i++){
            
            if(!set.contains(i) && (i+sum <= maxSum)){
                sum += i;
                count++;
            }
            if(sum > maxSum) break;
        }

        return count;
    }
}
//--------------------------- Approach: 02 --------------------------//
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean arr[] = new boolean[10001];
        for(int val: banned){
            arr[val] = true;
        }
        int sum = 0, count = 0;
        for(int i=1; i<=n; i++){
            
            if(arr[i] == true) continue;
            sum+= i;
            if(sum<=maxSum) count++;
            if(sum>maxSum) break;
        }
        return count;
    }
}
