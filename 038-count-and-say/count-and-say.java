// The count-and-say sequence is the sequence of integers with the first five terms as following:
//
// 1.     1
// 2.     11
// 3.     21
// 4.     1211
// 5.     111221
//
//
//
// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
//
//
//
// Given an integer n, generate the nth term of the count-and-say sequence.
//
//
//
// Note: Each term of the sequence of integers will be represented as a string.
//
//
// Example 1:
//
// Input: 1
// Output: "1"
//
//
//
// Example 2:
//
// Input: 4
// Output: "1211"
//
//


class Solution {
    public String countAndSay(int n) {
        String res="1";
            for(int i=1;i<n;i++){
                String prev=res;
                res=new String();
                    int count=1; 
                    for(int j=1;j<prev.length();j++){//due with prev
                        if(prev.charAt(j-1)!=prev.charAt(j)){//number changes
                            res=res+count+prev.charAt(j-1);
                            count=1;
                        //back to 1 and say changes
                        }
                            
                            else count++;
                    }
                res=res+count+prev.charAt(prev.length()-1);
            }
        return res;
    }
}
