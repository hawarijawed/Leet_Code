/*
Given an integer n, find a sequence that satisfies all of the following:

The integer 1 occurs once in the sequence.
Each integer between 2 and n occurs twice in the sequence.
For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.
The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.

Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a solution.

A sequence a is lexicographically larger than a sequence b (of the same length) if in the first position where a and b differ, sequence a has a number greater than the corresponding number in b. 
For example, [0,1,9,0] is lexicographically larger than [0,1,5,6] because the first position they differ is at the third number, and 9 is greater than 5.
*/
class Solution {
    public int[] constructDistancedSequence(int n) {
        boolean used[] = new boolean [n+1];
        int seq[] = new int[2*n - 1];
        backtrack(0,used, seq, n);
        return seq;
    }

    public boolean backtrack(int index, boolean used[], int seq[], int n){
        while(index < seq.length && seq[index] != 0){
            index++;
        }
        if(index == seq.length) return true;
        for(int i=n; i>=1; i--){
            if(used[i]) continue;
            if(i==1){
                seq[index] = i;
                used[i] = true;
                if(backtrack(index+1, used, seq, n)) return true;
                seq[index] = 0;
                used[i] = false;
            }
            else if(index+i < seq.length && seq[index+i] == 0){
                seq[index] = i;
                seq[index + i] = i;
                used[i] = true;
                if(backtrack(index+1, used, seq, n)) return true;
                seq[index] = 0;
                seq[index + i] = 0;
                used[i] = false;
            }
        }

        return false;
    }
}
