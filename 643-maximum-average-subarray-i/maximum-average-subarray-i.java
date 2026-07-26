class Solution {
    public double findMaxAverage(int[] nums, int k) {
     int i=0;
     int j=i+k-1;
     
     int maxsum=Integer.MIN_VALUE;
     while(j<nums.length){
        int sum=0;
        for(int l=i;l<=j;l++){
           sum+=nums[l];
           
        }
        maxsum=Math.max(sum,maxsum);
         i++;
         j++;
         
     }
     return (double)maxsum/k;
    }
}