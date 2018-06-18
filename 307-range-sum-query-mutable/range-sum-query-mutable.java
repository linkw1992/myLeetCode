// Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//
// The update(i, val) function modifies nums by updating the element at index i to val.
//
// Example:
//
//
// Given nums = [1, 3, 5]
//
// sumRange(0, 2) -> 9
// update(1, 2)
// sumRange(0, 2) -> 8
//
//
// Note:
//
//
// 	The array is only modifiable by the update function.
// 	You may assume the number of calls to update and sumRange function is distributed evenly.
//
//


class NumArray {
    int n;
    int[] nums;
    int[] BITS;
    public NumArray(int[] nums) {
        n=nums.length;
        this.nums=nums;
        BITS=new int[n+1];
        for(int i=0;i<n;i++){//put each element
            init(i,nums[i]);
        }
    }
    public void init(int i,int val){//construct binary index tree
        i++;
        while(i<=n){
            BITS[i]+=val;
            i+=(i&-i);
        }
    }
    
    public void update(int i, int val) {
        int diff=val-nums[i];
        nums[i]=val;//update
        init(i,diff);//BITS[i]+=diff
    }
    public int getSum(int i){
        int sum=0;i++;
        while(i>0){//back
            sum+=BITS[i];
            i-=(i&-i);
        }
        return sum;
    }
    
    public int sumRange(int i, int j) {
        return getSum(j)-getSum(i-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
