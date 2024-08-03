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
class BSTIterator {
    Stack<TreeNode> st ;
    public BSTIterator(TreeNode root) {
        st =  new Stack<>();
        while(root != null){
            st.add(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode t = st.pop();
        if(t.right != null) {
            TreeNode r = t.right;
            while(r != null){
                st.add(r);
                r = r.left;
            }
        }
        
        return t.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();   
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */