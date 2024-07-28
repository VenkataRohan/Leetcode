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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int f = 0;

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        if(root != null) q.add(root);

        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> cur = new ArrayList<>();
            for(int i =0; i<n ;i++){
                if(f == 1){
                    TreeNode t = q.remove();
                    cur.add(t.val);
                    if(t.right != null) q.add(t.right);
                    if(t.left != null) q.add(t.left);
                }else{
                    TreeNode t = q.removeLast();
                    cur.add(t.val);
                    if(t.left != null) q.addFirst(t.left);
                    if(t.right != null) q.addFirst(t.right);
                }
            }
            f = 1 - f;
            ans.add(new ArrayList<>(cur));
        }    
            return ans;
    }
}