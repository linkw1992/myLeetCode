//
// In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
//
//
// Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
//
//
// Return the result as a list of indices representing the starting position of each interval (0-indexed).  If there are multiple answers, return the lexicographically smallest one.
//
// Example:
//
// Input: [1,2,1,2,6,7,5,1], 2
// Output: [0, 3, 5]
// Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
// We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
//
//
//
// Note:
// nums.length will be between 1 and 20000.
// nums[i] will be between 1 and 65535.
// k will be between 1 and floor(nums.length / 3).
//


class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[3];        
        int[] acc=new int[n+1];
        for(int i=1;i<=n;i++){
            acc[i]=acc[i-1]+nums[i-1];
        }
        int[][] dp=new int[4][n+1];
        int[][] id=new int[4][n+1];
        for(int i=1;i<4;i++){//from 1 here
            for(int j=k*i;j<=n;j++){
                int tmp=acc[j]-acc[j-k]+dp[i-1][j-k];
                if(tmp>dp[i][j-1]){//when we have to change
                    dp[i][j]=tmp;
                    id[i][j]=j-k;
                }else{
                    dp[i][j]=dp[i][j-1];
                    id[i][j]=id[i][j-1];
                }
                               
            }
        }
        int ind=n; 
        for(int i=2;i>=0;i--){
                    res[i]=id[i+1][ind];
                    ind=res[i];
                }
                return res;
    }
}
