/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
*/
class Solution {
    List<String> list = new ArrayList<>();
    public void helperFunc(String curr, int Open, int closed, int n){
        if(Open == closed && closed == n){
            list.add(curr);
            return;
        }
        //Push open paranthesis
        if(Open < n){
            helperFunc(curr+"(",Open+1, closed, n);
        }

        //Push closed paranthesis into stack
        if(closed < Open){
            helperFunc(curr+")",Open, closed+1, n);
        }
    }
    public List<String> generateParenthesis(int n) {

        helperFunc("", 0,0, n);
        return list;
    }
}
