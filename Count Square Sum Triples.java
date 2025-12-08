/*
A square triple (a,b,c) is a triple where a, b, and c are integers and a2 + b2 = c2.

Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.
*/
class Solution {
    public int countTriples(int n) {
        int count = 0;
        for(int a = 1; a<=n; a++){
            for(int b = 1; b<=n; b++){
                int c = (int)Math.sqrt(a*a + b*b + 1.0);
                if(c<=n && c*c == (a*a + b*b)){
                    count++;
                }
            }
        }

        return count;
    }
}
