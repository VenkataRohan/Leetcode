class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = (int) 1e9 + 7;

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i =0 ; i<n;i++){
            pq.add(new int[]{nums[i],i});
        }

        int sum = 0;

        for(int i =0 ; i < right ;i++){
            int[] t = pq.remove();
            if(left-1 <= i){
                sum = (sum + t[0])%mod; 
            }

            if(t[1]+1 < n){
                pq.add(new int[]{t[0]+nums[t[1]+1],t[1]+1});
            }
        }

        return sum;
    }
}