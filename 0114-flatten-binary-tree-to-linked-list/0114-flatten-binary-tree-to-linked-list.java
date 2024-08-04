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
    public void flatten(TreeNode root) {
        if(root == null) return ;
        
           flatten(root.left);
           flatten(root.right);

           if(root.left != null){
                TreeNode t = root.right;
                TreeNode k = root.left;
                while(k.right != null){
                    k = k.right;
                }
                root.right = root.left;
                root.left = null;
                k.right = t;
           }
    }
}