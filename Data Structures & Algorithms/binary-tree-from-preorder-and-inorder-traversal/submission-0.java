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
    
    public TreeNode build(int[] preorder, int pre_index, int[] inorder, int s, int e){
        
        if(s > e) return null;
        
        int mid = s;

        while(inorder[mid] != preorder[pre_index]){
            mid++;
        }

        TreeNode root = new TreeNode(preorder[pre_index]);

        root.left = build(preorder, pre_index+1, inorder, s, mid-1);

        root.right = build(preorder, pre_index+mid-s+1, inorder, mid+1, e);

        return root;

    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, inorder, 0, inorder.length-1);
    }
}
