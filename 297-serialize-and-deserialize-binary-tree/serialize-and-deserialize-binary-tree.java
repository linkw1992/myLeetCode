// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
// Example: 
//
//
// You may serialize the following tree:
//
//     1
//    / \
//   2   3
//      / \
//     4   5
//
// as "[1,2,3,null,null,4,5]"
//
//
// Clarification: Just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
//
// Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
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
    String split=",";
    String empnode="#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serial(root, sb);
        return sb.toString();
    }
    void serial(TreeNode root, StringBuilder sb){
        if(root==null)
            sb.append(empnode).append(split);//add val and split
            else{
                sb.append(root.val).append(split);
                serial(root.left, sb);
                serial(root.right, sb);
            }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {//turn to list
        Deque<String> nodes=new LinkedList<>();//for head and tail
        nodes.addAll(Arrays.asList(data.split(split)));
        return buildTree(nodes);
    }
    TreeNode buildTree(Deque<String> nodes){//list to tree
        String val=nodes.remove();
        if(val.equals(empnode))return null;
        TreeNode node=new TreeNode(Integer.valueOf(val));
        node.left=buildTree(nodes);
        node.right=buildTree(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
