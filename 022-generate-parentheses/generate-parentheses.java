//
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
// For example, given n = 3, a solution set is:
//
//
// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]
//


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<String>();
        dfs(res,"",0,0,n);
        return res;
    }
        void dfs(List<String> res,String s, int i, int j, int max){
            if(s.length()==2*max){
             res.add(s);
            return;   
            }
            
        if(i<max)
            dfs(res,s+"(",i+1,j,max);
            if(j<i)
                dfs(res,s+")",i,j+1,max);
    }
}
