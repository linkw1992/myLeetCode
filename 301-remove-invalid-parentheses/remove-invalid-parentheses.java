//
// Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
//
// Note: The input string may contain letters other than the parentheses ( and ). 
//
//
//
// Examples:
//
// "()())()" -> ["()()()", "(())()"]
// "(a)())()" -> ["(a)()()", "(a())()"]
// ")(" -> [""]
//
//
//
// Credits:Special thanks to @hpplayer for adding this problem and creating all test cases.


class Solution {
    List<String> res=new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
       dfs(s,0,0,new char[]{'(',')'});
        return res;
    }
    void dfs(String s,int lasti,int lastj,char[] par){
        int stack=0;
        for(int i=lasti;i<s.length();i++){
            if(s.charAt(i)==par[0])stack++;
            if(s.charAt(i)==par[1])stack--;
                if(stack<0){
                    for(int j=lastj;j<=i;j++)
                        if(s.charAt(j)==par[1] &&(j==lastj||s.charAt(j-1)!=par[1]))
                            dfs(s.substring(0,j)+s.substring(j+1,s.length()),i,j,par);//substring without char(j)
                        return;
                }
        }       
        String rev=new StringBuilder(s).reverse().toString();
        if(par[0]=='(')
            dfs(rev,0,0, new char[]{')','('});
            else res.add(rev);
    }
}
