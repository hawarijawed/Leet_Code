/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.
*/

class Solution {
    public int candy(int[] ratings) {
        int size = ratings.length;
        int[] arr = new  int[size];
        for(int i=0; i<size; i++){
            arr[i] = 1;
        }

        //Left traversal
        for(int i=1; i<size; i++){
            if(ratings[i-1] < ratings[i]){
                arr[i] = arr[i-1]+1;
            }
        }
        //Right traversal
        for(int i= size-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                arr[i] = Math.max(arr[i],arr[i+1] + 1);
            }
        }

        int total_candies = 0;
        for(int candy: arr){
            total_candies += candy;
        }

        return total_candies;

    }
}
