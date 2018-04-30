//
// Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
// Solve it without division and in O(n).
//
// For example, given [1,2,3,4], return [24,12,8,6].
//
// Follow up:
// Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)


class Solution {
    public int[] productExceptSelf(int[] nums) {
   
        int n=nums.length;
        int[] output=new int[n];
        int i=1;
        output[0]=1;
        while(i<n){
            output[i]=output[i-1]*nums[i-1];
            i++;
        }
        int right=1;
        i=n-1;
        while(i>=0){
            output[i]*=right;
            right*=nums[i];
            i--;
        }
    return output;
    }
}
