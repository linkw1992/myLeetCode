// Given a collection of distinct integers, return all possible permutations.
//
// Example:
//
//
// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]
//
//


class Solution {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp=new ArrayList<Integer>();
        dfs(nums,temp,nums.length);
        return res;
    }
    void dfs(int[] nums,List<Integer> temp,int end){
        if(end==0)res.add(new ArrayList<>(temp));
        for(int i=0;i<nums.length;i++){
            if(!temp.contains(nums[i])){
                temp.add(nums[i]);
                dfs(nums,temp,end-1);
                temp.remove(temp.size()-1);
            }
        }
        
    }
}
