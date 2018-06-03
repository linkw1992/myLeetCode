// Design a data structure that supports the following two operations:
//
//
// void addWord(word)
// bool search(word)
//
//
// search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
//
// Example:
//
//
// addWord("bad")
// addWord("dad")
// addWord("mad")
// search("pad") -> false
// search("bad") -> true
// search(".ad") -> true
// search("b..") -> true
//
//
// Note:
// You may assume that all words are consist of lowercase letters a-z.
//


class WordDictionary {
    class TrieNode{
        TrieNode[] child=new TrieNode[26];
        String item="";
    }
    TrieNode root=new TrieNode();

    /** Initialize your data structure here. */
    public WordDictionary() {
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node=root;
        for(char c:word.toCharArray()){
            if(node.child[c-'a']==null)node.child[c-'a']=new TrieNode();
                node=node.child[c-'a'];
        }
        node.item=word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(),0, root);
    }
    boolean match(char[] c,int k, TrieNode root){
        if(k==c.length)return !root.item.equals("");
        if(c[k]!='.')
            return root.child[c[k]-'a']!=null && match(c,k+1,root.child[c[k]-'a']);
        else for(int i=0;i<root.child.length;i++){
            if(root.child[i]!=null &&match(c,k+1,root.child[i]))return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
