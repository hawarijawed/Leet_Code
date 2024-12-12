/*
You are given an integer array gifts denoting the number of gifts in various piles. Every second, you do the following:

Choose the pile with the maximum number of gifts.
If there is more than one pile with the maximum number of gifts, choose any.
Leave behind the floor of the square root of the number of gifts in the pile. Take the rest of the gifts.
Return the number of gifts remaining after k seconds.
*/
class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        long sum = 0;
        for(int i=0; i<gifts.length; i++){
            sum += gifts[i];
            pq.offer(gifts[i]);
        }

        for(int i=0; i<k; i++){
            if(pq.isEmpty()){
                break;
            }
            int largest = pq.poll();
            int sq = (int)Math.sqrt(largest);
            sum -= largest - sq;
            pq.offer(sq);
        }

        return sum;
    }
}
