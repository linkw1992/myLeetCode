// Given an unsorted array of integers, find the length of longest increasing subsequence.
//
// Example:
//
//
// Input: [10,9,2,5,3,7,101,18]
// Output: 4 
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
//
// Note: 
//
//
// 	There may be more than one LIS combination, it is only necessary for you to return the length.
// 	Your algorithm should run in O(n2) complexity.
//
//
// Follow up: Could you improve it to O(n log n) time complexity?
//


class Solution {
    public int lengthOfLIS(int[] nums) {
        int size=0;
        int[] targ=new int[nums.length];
        for(int n:nums){
            int i=0,j=size;//2 pointers
            while(i!=j){//binary search
                int m=i+(j-i)/2;
                if(targ[m]<n)i=m+1;
                else j=m;
            }
            targ[i]=n;
            if(i==size)size++;
            
        }
        return size;
    }
}
