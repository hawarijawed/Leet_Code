/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
*/
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<n; i++){
            if(map.get(s.charAt(i)) == 1)
            {
                return i;
            }
        }

        return -1;
    }
}

//----------------------------------------------------------------------------//
class Solution {
    public int firstUniqChar(String s) {
        int [] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<s.length(); i++){
            if(arr[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
