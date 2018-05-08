// Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
//
//
// 	Only one letter can be changed at a time.
// 	Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
//
//
// Note:
//
//
// 	Return 0 if there is no such transformation sequence.
// 	All words have the same length.
// 	All words contain only lowercase alphabetic characters.
// 	You may assume no duplicates in the word list.
// 	You may assume beginWord and endWord are non-empty and are not the same.
//
//
// Example 1:
//
//
// Input:
// beginWord = "hit",
// endWord = "cog",
// wordList = ["hot","dot","dog","lot","log","cog"]
//
// Output: 5
//
// Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.
//
//
// Example 2:
//
//
// Input:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log"]
//
// Output: 0
//
// Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
//
//
//
//
//


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict=new HashSet<String>();
        Set<String> v=new HashSet<String>();
        v.add(beginWord);
        for(String s:wordList){
            dict.add(s);
        }
        Queue<String> q=new LinkedList<String>();
        q.add(beginWord);
        q.add(null);
        if(!dict.contains(endWord))return 0;
        int count=1;
        while(!q.isEmpty()){
            String s=q.poll();
            if(s!=null){
                for(int i=0;i<s.length();i++){
                char[] ch=s.toCharArray();
                for(char c='a';c<='z';c++){
                    ch[i]=c;
                    String newWord=new String(ch);//char array to string
                    if(newWord.equals(endWord))return count+1;
                    if(dict.contains(newWord) &&!v.contains(newWord)){
                        q.add(newWord);
                        v.add(newWord);
                    }
                }
            }
            }else {
                count++;
                if(!q.isEmpty())q.add(null);//simbol null
            }
        }
        return 0;
    }
}
