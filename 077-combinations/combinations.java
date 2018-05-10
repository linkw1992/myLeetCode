// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
// Example:
//
//
// Input: n = 4, k = 2
// Output:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]
//
//


class Solution {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer>temp=new ArrayList<>();
        dfs(temp, 1,n,k);
        return res;
    }
    void dfs(List<Integer>temp, int begin, int end, int k){
        if(k==0)res.add(new ArrayList<>(temp));
            for(int i=begin;i<=end;i++){
                temp.add(i);
                dfs(temp,i+1,end,k-1);
                temp.remove(temp.size()-1);
            }
    }
}
