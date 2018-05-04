// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return the minimum cuts needed for a palindrome partitioning of s.
//
// Example:
//
//
// Input: "aab"
// Output: 1
// Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
//
//


class Solution {
    public int minCut(String s) {
        int[] cut=new int[s.length()];
        boolean[][] pal=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            int min=i;
            for(int j=0;j<=i;j++){//j是头，i是尾巴
                if(s.charAt(i)==s.charAt(j)&&(j+1>i-1||pal[j+1][i-1]==true)){//确保这部分是pal
                    pal[j][i]=true;
                    min=(j==0)?0:Math.min(min,cut[j-1]+1);
                }
            }
             cut[i]=min;   
        }
        return cut[s.length()-1];
    }
}
