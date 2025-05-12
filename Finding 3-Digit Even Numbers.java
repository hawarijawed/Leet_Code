/*
You are given an integer array digits, where each element is a digit. The array may contain duplicates.

You need to find all the unique integers that follow the given requirements:

The integer consists of the concatenation of three elements from digits in any arbitrary order.
The integer does not have leading zeros.
The integer is even.
For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.

Return a sorted array of the unique integers.
*/
//Approach 01: Optimized approach
class Solution{
public int[] findEvenNumbers(int [] digits){
        int[] digitCount = new int[10];
        for (int d : digits) digitCount[d]++;

        List<Integer> result = new ArrayList<>();

        for (int num = 100; num <= 999; num += 2) {
            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            int[] tempCount = new int[10];
            tempCount[a]++;
            tempCount[b]++;
            tempCount[c]++;

            boolean canForm = true;
            for (int i = 0; i < 10; i++) {
                if (tempCount[i] > digitCount[i]) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) result.add(num);
        }

        // Convert List to int[]
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) res[i] = result.get(i);
        return res;
    }
} 

//Approach 02: Brute Force 
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = digits.length;
        for(int i=0; i<n; i++){  
            for(int j=0; j<n; j++){            
                if(j==i) continue;
                for(int k=0; k<n; k++){
                    int num = 0;
                    if(k==i ||k==j) continue;
                    num = digits[i]*100+digits[j]*10+digits[k];
                    if(num%2==0 && num>=100){
                        map.put(num, map.getOrDefault(num, 0)+1);
                    }
                }
            }
        }

        int m = map.size();
        int [] res = new int[m];
        int j=0;
        for(int i=100; i<=999; i++){
            if(map.containsKey(i)){
                res[j++] = i;
            }
        }
        Arrays.sort(res);
        return res;
    }
}
