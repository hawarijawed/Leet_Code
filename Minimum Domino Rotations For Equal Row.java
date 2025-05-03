/*
In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.

If it cannot be done, return -1.
*/

class Solution {

    public int helper(int target, int[] tops, int []  bottoms){
        int topRotation = 0, bottomRotation = 0;
        int n = tops.length;

        for(int i=0; i<n; i++){
            if(tops[i] != target && bottoms[i] != target){
                return -1;
            }
            else if(tops[i] != target){
                topRotation++;
            }
            else if(bottoms[i] != target){
                bottomRotation++;
            }
        }

        return Math.min(topRotation, bottomRotation);
    }        
    
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int rotation = helper(tops[0], tops, bottoms);
        if(rotation != -1) return rotation;

        return helper(bottoms[0], tops, bottoms); 
    }
}
