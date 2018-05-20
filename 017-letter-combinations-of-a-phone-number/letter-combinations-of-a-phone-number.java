// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//
// Example:
//
//
// Input: "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// Note:
//
// Although the above answer is in lexicographical order, your answer could be in any order you want.
//


class Solution {
    LinkedList<String> res=new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())return res;
        String[] map={ "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for(int i=0;i<digits.length();i++){
            int x=digits.charAt(i)-'2';
            while(res.peek().length()==i){//get the t and remove it
                String t=res.remove();
                for(char s:map[x].toCharArray())//and add (t+s) again, it will become tail
                    res.add(t+s);
            }
    }
        return res;
            
    }
}
