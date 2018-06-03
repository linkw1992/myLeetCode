//
// Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
//
//
// Example 1:
//
// Input: 2736
// Output: 7236
// Explanation: Swap the number 2 and the number 7.
//
//
//
// Example 2:
//
// Input: 9973
// Output: 9973
// Explanation: No swap.
//
//
//
//
// Note:
//
// The given number is in the range [0, 108]
//
//


class Solution {
    public int maximumSwap(int num) {
        char[] c=Integer.toString(num).toCharArray();
        int[] bucket=new int[10];
        for(int i=0;i<c.length;i++){//to record last position for each number
            bucket[c[i]-'0']=i;
        }
        for(int i=0;i<c.length;i++){
            for(int j=9;j>c[i]-'0';j--){
                if(bucket[j]>i){//switch
                    char temp=c[bucket[j]];
                    c[bucket[j]]=c[i];
                    c[i]=temp;
                    return Integer.valueOf(new String(c));
                }
            }
        }
        return num;
    }
}
