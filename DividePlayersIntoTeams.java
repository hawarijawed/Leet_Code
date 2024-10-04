/*
You are given a positive integer array skill of even length n where skill[i] denotes the skill of the ith player. Divide the players into n / 2 teams of size 2 such that the total skill of each team is equal.
The chemistry of a team is equal to the product of the skills of the players on that team.
Return the sum of the chemistry of all the teams, or return -1 if there is no way to divide the players into teams such that the total skill of each team is equal.
*/
//----------------------------------- Approach: 01 using HashMap -----------------------------------//
class Solution {
    public long dividePlayers(int[] skill) {
        long sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<skill.length; i++){
            map.put(skill[i], map.getOrDefault(skill[i],0)+1);
            sum += skill[i];
        }

        int team_size = skill.length/2;
        int team_sum = (int)sum/team_size;
        if(sum%team_size != 0){
            return -1;
        }
        long res = 0;
        
        for(int i=0; i<skill.length; i++){
            int first_candidate = skill[i];
            if(map.get(first_candidate) == 0){
                continue;
            }
            map.put(first_candidate, map.get(first_candidate)-1);
            int next_candidate = team_sum - first_candidate;
            if(!map.containsKey(next_candidate) || map.get(next_candidate) == 0){
               return -1;
            }
            else{
                res += first_candidate*next_candidate;
                map.put(next_candidate, map.get(next_candidate)-1);
            }
        }
        return res;
    }
}

//----------------------------------- Approach: 02 using Array -----------------------------------//

class Solution {
    public long dividePlayers(int[] skill) {
        int sum = 0;
        int[] arr = new int[1001];
        int n = skill.length;
        for(int i=0; i<n; i++){
            arr[skill[i]]++;
            sum += skill[i];
        }
        
        int team_size = n/2;
        if(sum % team_size != 0){
            return -1;
        }
        int team_sum = sum/team_size;
        long res = 0;
        for(int i=0; i<n; i++){
            int first = skill[i];
            if(arr[first] == 0){
                continue;
            }
            arr[first] = arr[first]-1;
            int second = team_sum - first;
            if(arr[second] == 0){
                return -1;
            }
            else{
                res += first*second;
                arr[second] = arr[second]-1;
            }
        }
        return res;
    }
}
