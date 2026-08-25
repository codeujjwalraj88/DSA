class Solution {
    static boolean present(int[] arr,int n){
        for(int i=0;i<arr.length;i++){
            if(n==arr[i]){
                return true;
            }
        }
        return false;
    }
    public int missingMultiple(int[] nums, int k) {
        for(int i=k;i<=600;i=i+k){
           if(!present(nums,i)){
            return i;
           }
        }
        return -1;
    }
}