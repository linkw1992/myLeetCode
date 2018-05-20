// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
// Your algorithm should run in O(n) complexity.
//
// Example:
//
//
// Input: [100, 4, 200, 1, 3, 2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//
//


class Solution {
    public int longestConsecutive(int[] nums) {
        int res=0;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i:nums){
            if(!map.containsKey(i)){//avoid of dup
                int left=(map.containsKey(i-1))?map.get(i-1):0;
                int right=(map.containsKey(i+1))?map.get(i+1):0;
                int sum=left+right+1;//1 means i itself
                res=Math.max(sum,res);
                map.put(i,sum);
                map.put(i-left,sum);//not i-1
                map.put(i+right,sum);
            }
        }
        return res;
    }
}
