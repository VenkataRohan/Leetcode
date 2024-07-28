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
    class Pair{
        int n ;
        TreeNode node;

        Pair(TreeNode node, int n){
            this.node = node;
            this.n = n;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();

        if(root != null) q.add(new Pair(root,0));
        int ans = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int n = q.size();
            int f = 0, l = 0;
            int min = q.peek().n;
            for(int i = 0 ;i < n ; i++){
                Pair t = q.remove();
                if(i == 0) f = t.n;
                if(i == n-1) l = t.n;

                if(t.node.left != null) q.add(new Pair(t.node.left,2*(t.n-min) + 1));
                if(t.node.right != null) q.add(new Pair(t.node.right,2*(t.n-min) + 2));
            }
            ans = Math.max(ans,l - f + 1);
        }

        return ans;
    }
}