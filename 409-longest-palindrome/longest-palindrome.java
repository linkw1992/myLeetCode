// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
//
// This is case sensitive, for example "Aa" is not considered a palindrome here.
//
// Note:
// Assume the length of given string will not exceed 1,010.
//
//
// Example: 
//
// Input:
// "abccccdd"
//
// Output:
// 7
//
// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.
//
//


class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> h=new HashSet<Character>();
            int count=0;
        for(int i=0;i<s.length();i++){
            if(h.contains(s.charAt(i))){
                h.remove(s.charAt(i));
                count++;
            }
            else{
                h.add(s.charAt(i));
            }
        }
        if(h.isEmpty()){
            return count*2;
        }
        else return count*2+1;
    }
}
