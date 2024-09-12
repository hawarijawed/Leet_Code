/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
*/
class Solution {
    static HashMap<Character, String> map = new HashMap<>();
    static   { map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");}
    public void backtrack(StringBuilder str, String digits, int index, List<String> str1){
        if(index == digits.length()){
            str1.add(str.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = map.get(digit);
        for(char letter: letters.toCharArray()){
            str.append(letter);
            backtrack(str, digits, index+1, str1);
            str.deleteCharAt(str.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> str = new ArrayList<>();
        if(digits == null || digits.isEmpty()){
            return str;
        }

        backtrack(new StringBuilder(), digits, 0, str);
        return str;
    }
} 
