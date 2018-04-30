// Given a string, find the length of the longest substring without repeating characters.
//
// Examples:
//
// Given "abcabcbb", the answer is "abc", which the length is 3.
//
// Given "bbbbb", the answer is "b", with the length of 1.
//
// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null)return 0;
        int longlength=0,l=0;
        char[] c=s.toCharArray();
        Map<Character, Integer> map=new HashMap<Character, Integer>();           
        for(int i=0;i<s.length();i++){
            if(map.containsKey(c[i]))
            { l=Math.max(l,map.get(c[i])+1);}
            map.put(c[i],i);
            longlength =Math.max(longlength,i-l+1);
        }
        
        return longlength;
    }
}
