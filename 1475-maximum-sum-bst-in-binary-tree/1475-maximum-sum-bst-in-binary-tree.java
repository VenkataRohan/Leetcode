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
    int sum = 0;
    int[] solve(TreeNode root ){
        if(root == null) return new int[]{0,Integer.MIN_VALUE,Integer.MAX_VALUE};
        if(root.left == null && root.right == null){ 
            
            sum = Math.max(root.val,sum);
            return new int[]{root.val,root.val,root.val};}
        int[] l = solve(root.left);
        int[] r = solve(root.right);

        if(l[1] < root.val && r[2] > root.val){
            sum = Math.max(l[0]+r[0]+root.val,sum);
            return new int[]{l[0]+r[0]+root.val,Math.max(r[1],root.val),Math.min(l[2],root.val)};

        }

        return new int[]{Math.max(l[0],r[0]),Integer.MAX_VALUE,Integer.MIN_VALUE};
    }

    public int maxSumBST(TreeNode root) {
        int[] res=solve(root);
        return sum;
    }
}