// Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
// Example:
//
//
// Given array nums = [-1, 2, 1, -4], and target = 1.
//
// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//
//


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums.length<=2) return 0;
        int res=nums[0]+nums[1]+nums[2], minminus=Math.abs(res-target);
        int j=0, k=0,sum=0;
        for(int i=0;i<nums.length-2;i++){
            sum=target-nums[i];j=i+1;k=nums.length-1;
            while(j<k){
              if(j<k && nums[i]+nums[j]+nums[k]<target){
                    res=(target-nums[i]-nums[j]-nums[k]<minminus)?nums[i]+nums[j]+nums[k]:res;
                    minminus=(target-nums[i]-nums[j]-nums[k]<minminus)? target-nums[i]-nums[j]-nums[k]:minminus;
                   j++;}
              else if(j<k && nums[i]+nums[j]+nums[k]>target){
                   res=(-target+nums[i]+nums[j]+nums[k]<minminus)? nums[i]+nums[j]+nums[k]:res;
                   minminus=(-target+nums[i]+nums[j]+nums[k]<minminus)? -target+nums[i]+nums[j]+nums[k]:minminus;
                   k--;}
             else if(j<k && nums[i]+nums[j]+nums[k]==target)return nums[i]+nums[j]+nums[k];
         }
        }
        return res;
    }
}
