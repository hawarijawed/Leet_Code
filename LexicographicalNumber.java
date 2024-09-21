/*
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
You must write an algorithm that runs in O(n) time and uses O(1) extra space. 
*/
//------------------------------- O(n) Space solution -------------------------//
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> lst = new ArrayList<>();
        for(int i=1; i<10; i++){
            if(i>n){
                break;
            }
            dfs(i, n, lst);
        }
        return lst;
    }
    public void dfs(int currNum, int target, List<Integer> lst){
        if(currNum > target){
            return;
        }
        lst.add(currNum);
        for(int digit = 0; digit<10; digit++){
            if(currNum*10 + digit > target){
                break;
            }
            dfs(currNum*10+digit, target, lst);
        }
    }
}
//--------------------------------- O(1) Space solution ------------------------------//
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> lst = new ArrayList<>();
        int currNum = 1;
        for(int i=1; i<=n; i++){
            lst.add(currNum);
            if(currNum*10 <= n){
                currNum *= 10;
            }
            else{
                while(currNum%10 == 9 || currNum == n){
                    currNum /= 10;
                }
                currNum += 1;
            }
        }
        return lst;
    }
    
}
