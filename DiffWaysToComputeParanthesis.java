/*
Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.
The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.
*/
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int  n = expression.length();
        
        return recur(expression, 0, n-1);
    }

    public List<Integer> recur(String exp, int st, int end){
        List<Integer> list = new ArrayList<>();
        //base case: Single digit
        if(st == end){
            int num = exp.charAt(st) -'0';
            list.add(num);
            return list;
        }

        //base case: double digit
        if(end-st == 1 && Character.isDigit(exp.charAt(st))){
            // int num1 = exp.charAt(st) - '0';
            // int num2 = exp.charAt(end) - '0';
            int num = Integer.parseInt(exp.substring(st, end+1));

            list.add(num);
            return list;
        }
        //splitting the expression
        for(int i=st; i<=end; i++){
            if(Character.isDigit(exp.charAt(i))){
                continue;
            }
            char op = exp.charAt(i);
            List<Integer> left = recur(exp, st, i-1);
            List<Integer> right = recur(exp, i+1, end);
            for(int l : left){
                for(int r: right){
                    if(op == '*'){
                        list.add(l*r);
                    }
                    else if(op == '+'){
                        list.add(l+r);
                    }
                    else{
                        list.add(l-r);
                    }
                }
            }
        }

        return list;
    }
}
