// There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
// Example 1:
//
// nums1 = [1, 3]
// nums2 = [2]
//
// The median is 2.0
//
//
//
// Example 2:
//
// nums1 = [1, 2]
// nums2 = [3, 4]
//
// The median is (2 + 3)/2 = 2.5
//
//


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;        
        return (getkth(nums1,nums2,0,l1-1,0,l2-1,(l1+l2+1)/2)+getkth(nums1,nums2,0,l1-1,0,l2-1,(l1+l2+2)/2))/2.0;
    }
    int getkth(int[] nums1, int[] nums2, int i1, int i2, int j1, int j2, int k){
        int m=i2-i1+1;
        int n=j2-j1+1;
        if(m>n){//let m equal or be smaller than n
           return getkth(nums2, nums1, j1, j2, i1, i2, k); 
        }
        if(m==0)return nums2[j1+k-1];
        if(k==1)return Math.min(nums1[i1],nums2[j1]);
        int posA=Math.min(k/2,m);//sum of posA and posB is always k. Pay attention to the condition of k/2 > m
        int posB=k-posA;//pos is the number of moving step, not the sequence in the array
        if(nums1[i1+posA-1]==nums2[j1+posB-1])return nums1[i1+posA-1];
        else if(nums1[i1+posA-1]<nums2[j1+posB-1])
            return getkth(nums1, nums2, i1+posA, i2, j1, j1+posB-1, k-posA);//j1+posB-1
            else
                return getkth(nums1, nums2, i1, i1+posA-1, j1+posB, j2, k-posB);
        
        
    } 
}
