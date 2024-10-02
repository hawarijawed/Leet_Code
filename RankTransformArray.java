/*
Given an array of integers arr, replace each element with its rank.
The rank represents how large the element is. The rank has the following rules:
Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible.
*/
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int [] temp = arr.clone();
        //Sort the temp array
        Arrays.sort(temp);

        int prev = Integer.MIN_VALUE;
        int rank = 1;
        for(int i=0; i<n; i++){
            if(prev == temp[i]){
                continue;
            }
            map.put(temp[i],rank);
            prev = temp[i];
            rank++;
        }

        for(int i=0; i<n; i++){
            int ind = arr[i];
            arr[i] = map.get(ind);
        }
        
        return arr;
    }
}
