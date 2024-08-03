class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] temp = new int[1001];

        for(int i : target){
            temp[i]++;
        }

        for(int i:arr){
            temp[i]--;
        }

        for(int i : temp){
            if(i != 0) return false;
        }

        return true;
    }
}