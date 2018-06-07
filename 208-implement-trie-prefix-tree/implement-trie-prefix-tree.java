// Implement a trie with insert, search, and startsWith methods.
//
// Example:
//
//
// Trie trie = new Trie();
//
// trie.insert("apple");
// trie.search("apple");   // returns true
// trie.search("app");     // returns false
// trie.startsWith("app"); // returns true
// trie.insert("app");   
// trie.search("app");     // returns true
//
//
// Note:
//
//
// 	You may assume that all inputs are consist of lowercase letters a-z.
// 	All inputs are guaranteed to be non-empty strings.
//
//


class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
       root=new TrieNode(); 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ws=root;
        for(char c:word.toCharArray()){
            if(ws.child[c-'a']==null)ws.child[c-'a']=new TrieNode();
           ws=ws.child[c-'a'];//to next node
        }
        ws.isWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws=root;//have to write it each time
        for(char c:word.toCharArray()){
            if(ws.child[c-'a']==null)return false;
           ws=ws.child[c-'a'];//to next node
        }
        return ws.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws=root;
        for(char c:prefix.toCharArray()){
            if(ws.child[c-'a']==null)return false;
           ws=ws.child[c-'a'];//to next node
        }
        return true;
    }
}
class TrieNode{
    public boolean isWord;//record word
    public TrieNode[] child=new TrieNode[26];//for a-z
    public TrieNode(){};

    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
