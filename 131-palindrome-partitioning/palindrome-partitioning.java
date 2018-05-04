// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return all possible palindrome partitioning of s.
//
// Example:
//
//
// Input: "aab"
// Output:
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]
//
//


class Solution {
    List<List<String>> res=new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        List<String> temp=new ArrayList<String>();
        dfs(temp,s,0);
        return res;
    }
    void dfs(List<String> temp, String s, int start){
        if(start==s.length()){//遍历完一次
            res.add(new ArrayList<String>(temp));
        }
        else{ for(int i=start;i<s.length();i++){
            if(isPal(s,start,i)){
               
                    temp.add(s.substring(start,i+1));
                    dfs(temp,s,i+1);//这里是i不是start!如果是start+1只是遍历多一位，i+1则是下个substring
                    temp.remove(temp.size()-1);
            }
        }
        }
        }
    boolean isPal(String s,int start,int i){
        while(start<i){
            if(s.charAt(start)!=s.charAt(i))return false;
            start++;i--;
        }
        return true;
    }
}
