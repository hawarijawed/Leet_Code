/*
You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.

You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.

Return the minimum time taken to repair all the cars.

Note: All the mechanics can repair the cars simultaneously.
*/
class Solution {
    public long repairCars(int[] ranks, int cars) {
        long end = Long.MIN_VALUE;
        long start = Long.MAX_VALUE;
        for(int rank: ranks){
            end = Math.max(end, rank);
            start = Math.min(start, rank);
        }

        //Maximum time to repair all cars
        end = end* cars* cars;
        //Minimum time to repair a car will be start it self

        long ans = 0;
        while(start <= end){
            long mid = start + (end - start)/2;

            //If car can be repaired in start-mid range, then go for start - (mid-1)
            if(possibleToRepair(mid, ranks, cars)){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return ans;
    }

    private boolean possibleToRepair(long mid, int[] ranks, int cars){
        int repairedCars = 0;
        for(int rank: ranks){
            repairedCars += (long)Math.sqrt(1.0 * (mid/rank));
            if(repairedCars >= cars) return true;
        }

        return false;
    }
}
