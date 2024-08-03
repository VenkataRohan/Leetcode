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
    
    TreeNode solve(TreeNode root,int[] k){
         if(root == null) return root;
        
        TreeNode l = solve(root.left,k);
        k[0]--;
        if(k[0] == 0) return root;
        if(l != null) return l;
        TreeNode r = solve(root.right,k);
        return r; 
    }

    public int kthSmallest(TreeNode root, int k) {
        if(k == 0 || root == null) return -1;

        TreeNode l = solve(root,new int[]{k});
        return l == null ? -1 : l.val; 
    }
}