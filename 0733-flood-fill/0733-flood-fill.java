class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;

        int[] rr = new int[]{-1,0,1,0};
        int[] cc = new int[]{0,-1,0,1};
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sr,sc});
        int tt= image[sr][sc] ;
        while(!q.isEmpty()){
            int n = q.size();

            for(int i = 0;i<n;i++){
                int[] t = q.remove();

                for(int j = 0 ;j <4 ;j++){
                    int nr = t[0] + rr[j];
                    int nc = t[1] + cc[j];
                    if(nr >= 0 && nc >= 0 && nr < image.length && nc < image[0].length && image[nr][nc] == tt) {

                        q.add(new int[]{nr,nc});
                        image[nr][nc] = color;
                    }
                }
                image[t[0]][t[1]] = color;
            }
        }

        return image;
    }
}