class Solution {
    static boolean allodd(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                return true;
            }
        }
        return false;
    }
     static boolean alleven(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                return true;
            }
        }
        return false;
    }
    public boolean uniformArray(int[] nums1) {
        int[] arr=new int[nums1.length];
         for(int i=0;i<nums1.length-1;i++){
            arr[i]=arr[i]-arr[i+1];
            if(i==nums1.length-1){
                arr[i]=nums1[i];
            }
         }
         for(int i=0;i<arr.length;i++){
            if(arr[0]%2==0){
                if(alleven(arr)){
                    return true;
                }
            }else if(arr[0]%2!=0){
                if(allodd(arr)){
                    return true;
                }
            }
         }
         return false;
    }
}