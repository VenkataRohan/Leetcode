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

    TreeNode solve(int[] preorder ,  int[] ind , int ub){
        if(ind[0] >= preorder.length || preorder[ind[0]] > ub) return null;

        TreeNode root = new TreeNode(preorder[ind[0]++]);

        root.left = solve(preorder,ind,root.val);
        root.right = solve(preorder,ind,ub);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder,new int[]{0},1001);
    }
}