// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
//
//
// return its zigzag level order traversal as:
//
// [
//   [3],
//   [20,9],
//   [15,7]
// ]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        TreeNode curr;
        boolean z=false;//zigzag first line
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> temp=new ArrayList<Integer>();//refresh when a new loop
            int c=q.size();//size will change during the for loop
            for(int i=0;i<c;i++){
            curr=q.poll();
            if(z){
             temp.add(0,curr.val);   
            }
            else temp.add(curr.val);
            if(curr.left!=null)q.add(curr.left);
            if(curr.right!=null)q.add(curr.right);
            }
            res.add(temp);
            z=!z;
        }
        return res;
    }
}
