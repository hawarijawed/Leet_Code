/*
You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.
*/
class Pair {
    int value;  // The value from the list
    int listIndex; // Index of the list from which the value comes
    int elementIndex; // Index of the element in the list

    Pair(int value, int listIndex, int elementIndex) {
        this.value = value;
        this.listIndex = listIndex;
        this.elementIndex = elementIndex;
    }
}

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        int currentMax = Integer.MIN_VALUE;
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        // Initialize the heap and the current maximum
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minHeap.offer(new Pair(value, i, 0));
            currentMax = Math.max(currentMax, value);
        }

        // Process the heap
        while (minHeap.size() == nums.size()) {
            Pair currentMin = minHeap.poll();
            int currentRange = currentMax - currentMin.value;

            // Update the smallest range found
            if (currentRange < (rangeEnd - rangeStart) || 
                (currentRange == (rangeEnd - rangeStart) && currentMin.value < rangeStart)) {
                rangeStart = currentMin.value;
                rangeEnd = currentMax;
            }

            // If there's a next element in the same list, add it to the heap
            if (currentMin.elementIndex + 1 < nums.get(currentMin.listIndex).size()) {
                int nextValue = nums.get(currentMin.listIndex).get(currentMin.elementIndex + 1);
                minHeap.offer(new Pair(nextValue, currentMin.listIndex, currentMin.elementIndex + 1));
                currentMax = Math.max(currentMax, nextValue);
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }
}
