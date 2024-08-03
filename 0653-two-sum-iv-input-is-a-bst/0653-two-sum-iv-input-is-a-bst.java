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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> mp = new HashSet<>();

        Queue<TreeNode> q= new LinkedList<>();

        if(root != null) q.add(root);

        while(!q.isEmpty()){
            int n = q.size();
            for(int i =0 ; i < n; i++){
                TreeNode temp = q.remove();

                if(mp.contains(temp.val)) return true;

                mp.add(k - temp.val);

                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }
        return false;
    }
}