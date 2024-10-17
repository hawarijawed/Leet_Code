/*
You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.
*/
//------------------Aproach 01----------------//
class Solution {    

    public int maximumSwap(int num) {
        
        char[] digits = Integer.toString(num).toCharArray();
        int[] last = new int[10]; // Track the last occurrence of each digit

        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    // Found a larger digit to swap
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    return Integer.parseInt(new String(digits)); // Return immediately after swap
                }
            }
        }
    
        return num; // If no swap is possible, return original number

    }
}
//-------------Aproach 02 ------------//
class Solution {    
    public int arrToNum(int [] arr){
        int num = 0;
        for(int i=0; i<arr.length; i++){
            num = num*10+arr[i];
        }
        return num;
    }
    public int maximumSwap(int num) {
        int max = 0;
        String st = Integer.toString(num);
        int [] arr = new int[st.length()];
        for(int i=0; i<st.length(); i++){
            arr[i] = st.charAt(i) - '0';
        }
        for(int i=0; i<arr.length-1; i++){
            int a = arr[i];
            max = arr[i];
            int indx = i;
            for(int j=i+1; j<arr.length; j++){
                int b = arr[j];
                if(max < b || max == b){
                    max = b;
                    indx = j;
                }
            }
            if(max != a){
                arr[i] = max;
                arr[indx] = a;
                break;
            }
        }
        return arrToNum(arr);
    }
}
