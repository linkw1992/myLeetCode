// Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
//
// Example 1:
//
//
// Input: 123
// Output: "One Hundred Twenty Three"
//
//
// Example 2:
//
//
// Input: 12345
// Output: "Twelve Thousand Three Hundred Forty Five"
//
// Example 3:
//
//
// Input: 1234567
// Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
//
//


class Solution {
    String[] less20={"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] less100={"","Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousand={"","Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num==0)return "Zero";
        int i=0;
        String s=new String();
              while(num>0){
                  if(num%1000!=0)
                      s=towords(num%1000)+thousand[i]+" "+s;
                  num/=1000;
                  i++;
              }
        return s.trim();//with out space 
    }
    String towords(int num){//num<1000, remember the space
        if(num==0)return "";
        if(num<20)return less20[num]+" ";
        if(num<100)return less100[num/10]+" "+towords(num%10);
        return towords(num/100)+"Hundred "+towords(num%100);
    }
}
