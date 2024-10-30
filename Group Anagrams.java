


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i=0; i<strs.length; i++){
            String temp = strs[i];
            char[] character = temp.toCharArray();
            Arrays.sort(character);
            String st = new String(character);
            if(!map.containsKey(st)){
                map.put(st, new ArrayList<>());
            }
            map.get(st).add(temp);
        }

        return new ArrayList<>(map.values());
    }
}
