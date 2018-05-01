// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
// Each number in candidates may only be used once in the combination.
//
// Note:
//
//
// 	All numbers (including target) will be positive integers.
// 	The solution set must not contain duplicate combinations.
//
//
// Example 1:
//
//
// Input: candidates = [10,1,2,7,6,1,5], target = 8,
// A solution set is:
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]
//
//
// Example 2:
//
//
// Input: candidates = [2,5,2,1,2], target = 5,
// A solution set is:
// [
//   [1,2,2],
//   [5]
// ]
//
//


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(res,temp,candidates,target,0);
        return res;
    }
    void dfs(List<List<Integer>> res,List<Integer> temp,int[] candidates, int target,int start){
        if(target<0)return;
        else if(target==0)res.add(new ArrayList<Integer>(temp));
        else for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1])continue;
            temp.add(candidates[i]);
            dfs(res,temp,candidates,target-candidates[i],i+1);
            temp.remove(temp.size()-1);
        }
    }
}
