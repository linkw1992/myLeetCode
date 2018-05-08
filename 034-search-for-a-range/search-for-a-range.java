// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// If the target is not found in the array, return [-1, -1].
//
// Example 1:
//
//
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
//
// Example 2:
//
//
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
//


class Solution {
    public int[] searchRange(int[] nums, int target) {        
        int b=0,e=nums.length-1;
        int[] res=new int[2];
        if(nums==null||nums.length==0)return new int[]{-1,-1};
        while(b<e){//left side
            int mid=(e+b)/2;
            if(target>nums[mid])b=mid+1;
            else e=mid;
        }
            if(target==nums[b])res[0]=b;
            else res[0]=-1;
        e=nums.length-1;
        while(b<e){
            int mid=(b+e+1)/2;
            if(target<nums[mid])e=mid-1;//e changes only when target is smaller than mid
            else b=mid;
        }
            if(target==nums[e])res[1]=e;
            else res[1]=-1;
        return res;
    }
}
