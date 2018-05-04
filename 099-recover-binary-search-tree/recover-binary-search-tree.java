// Two elements of a binary search tree (BST) are swapped by mistake.
//
// Recover the tree without changing its structure.
//
// Example 1:
//
//
// Input: [1,3,null,null,2]
//
//    1
//   /
//  3
//   \
//    2
//
// Output: [3,1,null,null,2]
//
//    3
//   /
//  1
//   \
//    2
//
//
// Example 2:
//
//
// Input: [3,1,4,null,null,2]
//
//   3
//  / \
// 1   4
//    /
//   2
//
// Output: [2,1,4,null,null,3]
//
//   2
//  / \
// 1   4
//    /
//   3
//
//
// Follow up:
//
//
// 	A solution using O(n) space is pretty straight forward.
// 	Could you devise a constant space solution?
//
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
    TreeNode first=null; 
    TreeNode second=null; 
    TreeNode prev=new TreeNode(Integer.MIN_VALUE); //初始化prev比root小
    public void recoverTree(TreeNode root) {
        trav(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;//交换prev和root在prev大于root时
    }
    void trav(TreeNode root){
        if(root==null)return;
        trav(root.left);
        if(first==null && prev.val>=root.val){
            first=prev;
        }
            if(first!=null && prev.val>=root.val){
                second=root;
            }
                
                prev=root;//prev是正在遍历点的前一个点
        trav(root.right);
    }
}
