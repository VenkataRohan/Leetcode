/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer,Node> mp = new HashMap<>();
        boolean[] vis = new boolean[101];
        
        vis[node.val] = true;

        Queue<Node> q = new LinkedList<>();

            Node root = new Node(node.val);
            mp.put(node.val,root);
        
            q.add(node);

        while(!q.isEmpty()){
            Node t = q.remove();
            Node n = mp.get(t.val);
             vis[t.val] = true;
            for(Node i : t.neighbors){
                if(!mp.containsKey(i.val)){
                    mp.put(i.val,new Node(i.val));
                }
                n.neighbors.add(mp.get(i.val));
                if(!vis[i.val]) {
                    vis[i.val] = true;
                    q.add(i);

                }
            }
        }
        return root;
    }
}