/*
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
Since the result may be very large, so you need to return a string instead of an integer.
*/
class Solution {
    public String largestNumber(int[] nums) {
        int size = nums.length;
        String elements[] = new String[size];
        for(int i=0; i<size; i++){
            elements[i] = Integer.toString(nums[i]);
        }
        //Applying custom comparator on elements
        Arrays.sort(elements, new Comparator<String>(){
            public int compare(String a, String b){
                String first = a+b; 
                String second = b+a;
                return second.compareTo(first);
            }
        });
        if(elements[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++){
            sb.append(elements[i]);
        }

        return sb.toString();
    }
}
