//
//     Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
//
//
//
//     Example 1:
//     Given words = ["bat", "tab", "cat"]
//     Return [[0, 1], [1, 0]]
//     The palindromes are ["battab", "tabbat"]
//
//
//     Example 2:
//     Given words = ["abcd", "dcba", "lls", "s", "sssll"]
//     Return [[0, 1], [1, 0], [3, 2], [2, 4]]
//     The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
//
//
// Credits:Special thanks to @dietpepsi for adding this problem and creating all test cases.


class Solution {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> palindromePairs(String[] words) {
        if(words==null||words.length==1)return res;
        Map<String,Integer> map=new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++)map.put(words[i],i);//我们要求的是i,所以i要放在value
        for(int i=0;i<words.length;i++){
            for(int j=0;j<=words[i].length();j++){//拆两半,j<=不是<
                String s1=words[i].substring(0,j);//这里不用new，这句话是从0到j-1的字符
                String s2=words[i].substring(j);
                    if(isPal(s1)){//s1之外剩下的部分，在数列里有i之外的转置，加起来才是pal
                        String s2r=new StringBuilder(s2).reverse().toString();//转置之
                            if(map.containsKey(s2r) && map.get(s2r)!=i){
                                List<Integer> temp=new ArrayList<Integer>();
                                temp.add(map.get(s2r));
                                temp.add(i);
                                res.add(temp);
                            }
                    }
                        if(isPal(s2)){//同理s2
                        String s1r=new StringBuilder(s1).reverse().toString();//转置之
                            if(map.containsKey(s1r) && map.get(s1r)!=i && s2.length()!=0){//后者是为了去掉重复！！
                                List<Integer> temp=new ArrayList<Integer>();
                                temp.add(i);
                                temp.add(map.get(s1r));//s1r要接在word[i]后面，因为这里s2是后半段
                                res.add(temp);
                            }
                        
                    }
        }
        
    }
        return res;
    }
    boolean isPal(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1))return false;
        }
        return true;
    }
}
