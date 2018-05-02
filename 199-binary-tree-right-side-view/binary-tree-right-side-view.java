// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
// Example:
//
//
// Input: [1,2,3,null,5,null,4]
// Output: [1, 3, 4]
// Explanation:
//
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
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
    List<Integer> res=new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        bfs(root,0);
        return res;
    }
    void bfs(TreeNode root, int depth){
        if(root==null)return;
        if(depth==res.size()){
            res.add(root.val);
        }
        bfs(root.right,depth+1);
        bfs(root.left,depth+1);
    }
}
