/*
You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.

You are also given an integer k, which is the desired number of consecutive black blocks.

In one operation, you can recolor a white block such that it becomes a black block.

Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.
*/
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int w = 0;
        for(int i=0; i<k; i++){
            if(blocks.charAt(i) == 'W') w++;
        }

        int res = w;
        for(int i=1; i<(blocks.length() - k + 1);i++){
            if(blocks.charAt(i-1) == 'W') w--;
            if(blocks.charAt(i + k -1) == 'W') w++;

            res = Math.min(res, w);
        }

        return res;
    }
}
