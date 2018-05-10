// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment. 
//
// Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
//
// The encoded string should be as compact as possible.
//
//
//
// Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
//


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "#!";//# for null
        String res=root.val+"!";
        res+=serialize(root.left);
        res+=serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] string=data.split("!");
        Queue<String>q=new LinkedList<>();
        for(String s:string){
            q.add(s);
        }
        return builtTree(q);
        
    }
    TreeNode builtTree(Queue<String>q) {//trans q to tree
        String s=q.poll();//LinkedList.poll()
        if(s.equals("#"))return null;
        TreeNode root=new TreeNode(Integer.valueOf(s));
        root.left=builtTree(q);
        root.right=builtTree(q);
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
