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
    
    int pre_idx = 0;
    HashMap<Integer, Integer> indices = new HashMap<>();

    public TreeNode build(int[] preorder, int s, int e){
        
        if(s > e) return null;
        
        int root_val = preorder[pre_idx++];
        int mid = indices.get(root_val);;

        TreeNode root = new TreeNode(root_val);

        root.left = build(preorder, s, mid-1);

        root.right = build(preorder, mid+1, e);

        return root;

    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length-1);
    }
}
