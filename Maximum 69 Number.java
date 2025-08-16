/*
You are given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
*/
class Solution {
    public int maximum69Number (int num) {
        String st = String.valueOf(num);
        Character[] ch = new Character[st.length()];
        boolean isFound = false;
        for(int i=0; i<st.length(); i++){
            if(!isFound && st.charAt(i) == '6'){
                ch[i] = '9';
                isFound = true;
                continue;
            }
            ch[i] = st.charAt(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<ch.length; i++){
            sb.append(ch[i]);
        }

        return Integer.parseInt(sb.toString());
    }
}
