class Solution {
    public int longestMountain(int[] arr) {

         int ans=0;
       for(int i=1;i<arr.length-1;i++){
         if(arr[i]>arr[i-1]&&arr[i]>arr[i+1]){
             int count=1;
                 int j=i;int k=i;
                 while(j>0&&arr[j]>arr[j-1]){
                    j--;count++;
                 }
                 while(k<arr.length-1&&arr[k]>arr[k+1]){
                    k++;count++;
                 }
                 ans=Math.max(ans,count);
        }
       }
      return ans;
    }
}