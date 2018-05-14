// Given an array of strings, group anagrams together.
//
// Example:
//
//
// Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Output:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
//
// Note:
//
//
// 	All inputs will be in lowercase.
// 	The order of your output does not matter.
//
//


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0)return new ArrayList<List<String>>();
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        for(String s:strs){
            char[] c=s.toCharArray();
                Arrays.sort(c);
            String key=String.valueOf(c);//not toString()
            if(!map.containsKey(key))map.put(key,new ArrayList<String>());//put(key,value)
            map.get(key).add(s);//add value s in the "key" key
        }
        return new ArrayList<List<String>>(map.values());//map.value() is just List<List<String>>
    }
}
