// Given two binary strings, return their sum (also a binary string).
//
// The input strings are both non-empty and contains only characters 1 or 0.
//
// Example 1:
//
//
// Input: a = "11", b = "1"
// Output: "100"
//
// Example 2:
//
//
// Input: a = "1010", b = "1011"
// Output: "10101"
//


class Solution {
    public String addBinary(String a, String b) {
        StringBuilder s=new StringBuilder();//StringBuilder method
        int i=a.length()-1,j=b.length()-1;
        int sum=0;
        while(i>=0||j>=0){
            if(i>=0)sum+=a.charAt(i--)-'0';
            if(j>=0)sum+=b.charAt(j--)-'0';
            s.append(sum%2);
            sum=sum/2;
        }
        if(sum!=0)s.append(sum);//put to the last place
        return s.reverse().toString();//so we have to reverse
    }
}
