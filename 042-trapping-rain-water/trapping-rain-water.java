// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//
// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
//
// Example:
//
//
// Input: [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6


class Solution {
    public int trap(int[] height) {
        int len=height.length;
        int leftBar=0,rightBar=0,max=0;
        int i=0,j=len-1;
        while(i<j){//否则会少一个被计算的数
            leftBar=Math.max(leftBar,height[i]);
            rightBar=Math.max(rightBar,height[j]);
            if(leftBar<rightBar){
                max+=leftBar-height[i];
                i++;
            }
            else{
                max+=rightBar-height[j];
                j--;
            }
        }
        return max;
    }
}
