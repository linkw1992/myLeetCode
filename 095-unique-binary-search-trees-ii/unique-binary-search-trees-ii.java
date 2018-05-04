// Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
//
// Example:
//
//
// Input: 3
// Output:
// [
//   [1,null,3,2],
//   [3,2,null,1],
//   [3,1,null,null,2],
//   [2,1,3],
//   [1,null,2,null,3]
// ]
// Explanation:
// The above output corresponds to the 5 unique BST's shown below:
//
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {//后面的部分没办法写成void吗？
        if(n==0)return new ArrayList<>();
        return dfs(1,n);
    }
    List<TreeNode> dfs(int start, int n){
        List<TreeNode> res=new ArrayList<TreeNode>();
        if(start>n){
            res.add(null);
            return res;
        }
        if(start==n){
            res.add(new TreeNode(start));//树类节点声明方法，和list不一样
            return res;
        }
        List<TreeNode>left,right;
    for(int i=start;i<=n;i++){
         left=dfs(start,i-1);
         right=dfs(i+1,n);
        for(TreeNode l:left){
        for(TreeNode r:right){
            TreeNode root=new TreeNode(i);
            root.left=l;
            root.right=r;
            res.add(root);
        }
        
    }
}return res;
    }
}
