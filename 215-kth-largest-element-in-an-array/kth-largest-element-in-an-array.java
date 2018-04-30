// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.
//
// Note: 
// You may assume k is always valid, 1 ≤ k ≤ array's length.
//
// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.
//


class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q=new PriorityQueue<Integer>();
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(i<k)q.add(nums[i]);
            else if(nums[i]>q.peek()){
                q.poll();
                q.add(nums[i]);
            }
        }
        return q.peek();
    }
}
