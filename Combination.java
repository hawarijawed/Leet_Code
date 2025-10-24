/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.
*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k>n) return res;
        combination(res, n, k, 1, new ArrayList<>());
        return res;
    }

    public void combination(List<List<Integer>> res, int n, int k, int indx, List<Integer> lst){
        if(lst.size() == k){
            res.add(new ArrayList<>(lst));
            return;
        }
        for(int i=indx; i<=n; i++){
            lst.add(i);
            combination(res, n, k, i+1, lst);
            lst.remove(lst.size()-1);
        }
    }
}
