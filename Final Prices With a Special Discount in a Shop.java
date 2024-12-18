/*
You are given an integer array prices where prices[i] is the price of the ith item in a shop.

There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.

Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.
*/
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        
        for(int i=n-1; i>=0; i--){
            //Clear all the greater elements present in the stack
            while(!stack.isEmpty() && stack.peek() > prices[i]){
                stack.pop();
            }
            int val = prices[i];
            //Update the prices[i[]]
            if(!stack.isEmpty()){
                prices[i] -= stack.peek();
            }
            stack.push(val);
        }
        return prices;
    }
}
