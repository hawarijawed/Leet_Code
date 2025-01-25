/*
You are given a 0-indexed array of positive integers nums and a positive integer limit.

In one operation, you can choose any two indices i and j and swap nums[i] and nums[j] if |nums[i] - nums[j]| <= limit.

Return the lexicographically smallest array that can be obtained by performing the operation any number of times.

An array a is lexicographically smaller than an array b if in the first position where a and b differ, array a has an element that is less than the corresponding element in b. For example, the array [2,10,3] is lexicographically smaller than the array [10,2,3] because they differ at index 0 and 2 < 10.
*/
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int temp[] = new int[n];
        for(int i=0; i<n; i++){
            temp[i] = nums[i];
        }

        Arrays.sort(temp);

        ArrayList<Deque<Integer>> list = new ArrayList<>();
        //Maps temp[i] -> groupIndex
        HashMap<Integer, Integer> group = new HashMap<>();
     
        int groupIndex = 0;
        list.add(new LinkedList<>());
        list.get(groupIndex).offer(temp[0]);
        group.put(temp[0], groupIndex);

        for(int i=1; i<n; i++){
            int lastElement = list.get(groupIndex).peekLast();
            //Check for limit
            if(temp[i] - lastElement > limit){
                groupIndex++;
                list.add(new LinkedList<>());
            } 
            group.put(temp[i], groupIndex);
            list.get(groupIndex).offer(temp[i]);
        }


        for(int i=0; i<n; i++){
            int gi = group.get(nums[i]);//Get the groupIndex with help of nums[i] element
            nums[i] = list.get(gi).poll();//Assigns the lowest element of that group
        }

        return nums;

    }
}
