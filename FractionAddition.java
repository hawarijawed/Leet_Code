/*
Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.

The final result should be an irreducible fraction. If your final result is an integer, change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.
*/
class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;
        int n = expression.length();
        int indx = 0;
        while(indx<n){
            int curr_numerator = 0;
            int curr_denominator =1;
            boolean isNeg = false;
            //Extracting string characters
            char ch = expression.charAt(indx);
            if(ch =='+' || ch == '-'){
                if(ch == '-'){
                    isNeg = true;
                }
                indx++;
            }

            //Forming a numerator
            int start = indx;
            while(Character.isDigit(expression.charAt(indx))){
                indx++;
            }

            curr_numerator = Integer.parseInt(expression.substring(start, indx));
            if(isNeg){
                curr_numerator *= -1;
            }
            indx++;

            //Forming denominator
            //Forming a number
            start = indx;
            while(indx<n &&Character.isDigit(expression.charAt(indx))){
                indx++;
            }

            curr_denominator = Integer.parseInt(expression.substring(start, indx));
            numerator = numerator*curr_denominator + curr_numerator*denominator;
            denominator *= curr_denominator;
        }

        //GCD calculation
        int gcd = Math.abs(getGCD(numerator,denominator));
        numerator /= gcd;
        denominator /= gcd;
        return numerator+"/"+denominator;
    }

    public int getGCD(int a, int b){
        if(a==0){
            return b;
        }

        return getGCD(b%a,a);
    }
}
