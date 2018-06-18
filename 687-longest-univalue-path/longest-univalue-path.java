// Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
//
// Note: The length of path between two nodes is represented by the number of edges between them.
//
//
// Example 1:
//
//
//
//
// Input:
//
//               5
//              / \
//             4   5
//            / \   \
//           1   1   5
//
//
//
//
// Output:
//
// 2
//
//
//
//
// Example 2:
//
//
//
//
// Input:
//
//               1
//              / \
//             4   5
//            / \   \
//           4   4   5
//
//
//
//
// Output:
//
// 2
//
//
//
// Note:
// The given binary tree has not more than 10000 nodes.  The height of the tree is not more than 1000.
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
class Solution {
    int len=0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)return 0;
        dfs(root,root.val);
        return len;
    }
    int dfs(TreeNode root,int val){
        if(root==null)return 0;
        int left=dfs(root.left,root.val);
        int right=dfs(root.right,root.val);
        len=Math.max(left+right,len);
        if(root.val==val) return Math.max(left,right)+1;
        return 0;
    }
}
