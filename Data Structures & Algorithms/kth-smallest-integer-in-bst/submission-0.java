/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    
    public int res;

    int dfs(TreeNode root, int k){
        if(root == null) return 0;
        int l = dfs(root.left, k);
        if(l+1 == k){
            res = root.val;
        }
        int r = dfs(root.right, k-l-1);
        return l+r+1;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        res = -1;
        dfs(root, k);
        return res;
    }
}
