// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
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
// return its level order traversal as:
//
// [
//   [3],
//   [9,20],
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelO = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root==null)return levelO;
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> level =new ArrayList<Integer>();
            int l=q.size();
            for(int i=0;i<l;i++){
               if(q.peek().left!=null)q.offer(q.peek().left);
               if(q.peek().right!=null)q.offer(q.peek().right);  
                level.add(q.poll().val);
            }

            levelO.add(level);
        }      
      return levelO;  
    }
}
