/*
You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.

*/
class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            char ch = s.charAt(i);
            if((ch-'0')>=0 && (ch-'0')<=9){
                sb.deleteCharAt(sb.length()-1);
                continue;
            }

            sb.append(ch);
        }

        return sb.toString
    }
}
