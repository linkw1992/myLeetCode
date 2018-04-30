//
// Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
//
//
// For example: 
// Given "aacecaaa", return "aaacecaaa".
// Given "abcd", return "dcbabcd".
//
// Credits:Special thanks to @ifanchu for adding this problem and creating all test cases. Thanks to @Freezen for additional test cases.


class Solution {
    public String shortestPalindrome(String s) {
        
        String temp=s+'#'+ new StringBuilder(s).reverse().toString();
            int[] table=getTable(temp);
            return new StringBuilder(s.substring(table[table.length-1])).reverse().toString()+s;
    }
    public int[] getTable(String s){
        int[] table=new int[s.length()];
        int k=0;
        for(int i=1;i<s.length();i++){//错位比较，就是从i=1开始比较，否则会runtime
            if(s.charAt(i)==s.charAt(k)){
                k++;
            }
            else{
                k=table[i-1];
              while(k>0 && s.charAt(i)!=s.charAt(k)){
                k=table[k-1];
            }  
            if(s.charAt(i)==s.charAt(k)){
                k++;
            }
            }
          table[i]=k;  
        }
        return table;
    }
}
