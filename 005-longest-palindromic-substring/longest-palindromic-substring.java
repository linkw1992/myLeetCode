// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
// Example 1:
//
//
// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
//
//
// Example 2:
//
//
// Input: "cbbd"
// Output: "bb"
//
//


class Solution {
    public String longestPalindrome(String s) {
        int start=0, leng=0;
        for (int i =0;i<s.length();i++){
            int len1=CentrualPalindrome(s,i,i+1);
            int len2=CentrualPalindrome(s,i,i);
            int len3=Math.max(len1, len2);
                if(len3>leng){
                    leng=len3;
                    start=i-(leng-1)/2;
                }
        }
        return s.substring(start,start+leng);
    }
    private int CentrualPalindrome(String s, int left,int right){
        int l=left, r=right;
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            
            l--;r++;
        }
        return r-l-1;
        
    }
}
