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
        TreeNode node;
        int n,r;

        Pair(TreeNode node , int n,int r){
            this.node = node;
            this.r = r;
            this.n = n;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();

        if(root != null) q.add(new Pair(root,0,0));

        Map<Integer,PriorityQueue<Pair>> mp = new TreeMap<>();

        while(!q.isEmpty()){
            int n = q.size();

            for(int i =0 ;i < n ; i++){
                Pair t = q.remove();
                if(!mp.containsKey(t.n)){
                    mp.put(t.n,new PriorityQueue<>((a,b)->a.r == b.r ? a.node.val - b.node.val : a.r - b.r));
                }
                mp.get(t.n).add(t);
                
                if(t.node.left != null) q.add(new Pair(t.node.left,t.n-1,t.r+1));
                if(t.node.right != null) q.add(new Pair(t.node.right,t.n+1,t.r+1));
            }
        }

        for(int i : mp.keySet()){
            List<Integer> t = new ArrayList<>();
            PriorityQueue<Pair> pq = mp.get(i);
            while(!pq.isEmpty()){
                t.add(pq.remove().node.val);
            }
            ans.add(new ArrayList<>(t));
        }

        return ans;
    }
}