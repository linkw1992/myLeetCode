//
// You are given an integer array nums and you have to return a new counts array.
// The counts array has the property where counts[i] is 
// the number of smaller elements to the right of nums[i].
//
//
// Example:
//
//
// Given nums = [5, 2, 6, 1]
//
// To the right of 5 there are 2 smaller elements (2 and 1).
// To the right of 2 there is only 1 smaller element (1).
// To the right of 6 there is 1 smaller element (1).
// To the right of 1 there is 0 smaller element.
//
//
//
// Return the array [2, 1, 1, 0].
//


class Solution {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        count=new int[nums.length];
        int[] index=new int[nums.length];
        List<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            index[i]=i;
        }
            mergesort(nums,index,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            res.add(count[i]);
        }
        return res;
    }
    void mergesort(int[] nums,int[] index,int b, int e){
        if(e<=b)return;
        int mid=(b+e)/2;
        mergesort(nums,index,b, mid);
        mergesort(nums,index,mid+1, e);
        merge(nums,index,b,e);
    }
    void merge(int[] nums,int[] index,int b, int e){//index的一部分排序
        int mid=(b+e)/2;
        int left=b;
        int right=mid+1;
        int rightcount=0;//顺序不对的数目
        int sort=0;
        int[] nind=new int[e-b+1];
        while(left<=mid && right<=e){
            if(nums[index[right]]<nums[index[left]]){
                nind[sort]=index[right];
                rightcount++;
                right++;
            }
            else{
            nind[sort]=index[left];
                count[index[left]]+=rightcount;
                left++;
            }
            sort++;
        }
        while(left<=mid){//和else部分比较近，毕竟没有right部分了
            nind[sort]=index[left];
            count[index[left]]+=rightcount;
                left++;
                sort++;
        }
        while(right<=e){//类似上面,不过count不加
            nind[sort]=index[right];
                right++;
                sort++;
        }
        for(int i=b;i<=e;i++){
             index[i]=nind[i-b];
        }
        
    }
}
