// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given the below binary tree and sum = 22,
//
//
//       5
//      / \
//     4   8
//    /   / \
//   11  13  4
//  /  \    / \
// 7    2  5   1
//
//
// Return:
//
//
// [
//    [5,4,11,2],
//    [5,8,4,5]
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
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> temp=new ArrayList<Integer>();
        dfs(root,sum,temp);
        return res;
    }
    void dfs(TreeNode root, int sum,List<Integer> temp){
        if(root==null)return;
        temp.add(root.val);
        if(root.left==null &&root.right==null && sum==root.val)
            res.add(new ArrayList<>(temp));
            dfs(root.left,sum-root.val,temp);
            dfs(root.right,sum-root.val,temp);
        temp.remove(temp.size()-1);
        }
    }
