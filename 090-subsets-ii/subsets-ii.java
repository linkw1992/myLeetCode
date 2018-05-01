// Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
//
// Input: [1,2,2]
// Output:
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]
//


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(res,temp,nums,0);
        return res;
    }
    void dfs(List<List<Integer>> res,List<Integer> temp,int[] nums, int start){
        res.add(new ArrayList<Integer>(temp));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1])continue;
            temp.add(nums[i]);
            dfs(res,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
        
    }
}

