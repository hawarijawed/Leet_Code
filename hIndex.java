class Solution {
    public int hIndex(int[] citations) {

        //Sorted is [0,1,3,5,6]
        Arrays.sort(citations); 
        int n = citations.length;
        int hIndex = 0;

        // Step 2: Iterate from the end and find the h-index
        for (int i = 0; i < n; i++) {
            int h = n - i;  // h is the number of papers with at least citations[i] citations
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }

        return hIndex;
    }
}
