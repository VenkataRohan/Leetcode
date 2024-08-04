class KthLargest {

    PriorityQueue<Integer> pq ;
    int k ;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int i : nums){
            add(i);        
        }
    }
    
    public int add(int val) {
        if(pq.size()<k){
            pq.add(val);
        }
        else if(val > pq.peek()){
            pq.remove();
            pq.add(val);
        }

        return pq.peek();
    }
}


// 2 3 4 5 8 

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */