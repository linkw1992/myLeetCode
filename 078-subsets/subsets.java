// Given a set of distinct integers, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
//
// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
//


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer>temp =new ArrayList<Integer>();
        dfs(res,temp,nums,0);
        return res;
    }
    void dfs(List<List<Integer>> res,List<Integer>temp,int[] nums, int start){
        res.add(new ArrayList<>(temp));//这里必须要定义！！因为list是抽象类
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(res,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
