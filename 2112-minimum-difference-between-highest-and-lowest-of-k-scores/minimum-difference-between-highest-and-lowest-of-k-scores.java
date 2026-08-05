class Solution {
    public int minimumDifference(int[] nums, int k) {
       int i=0;
       int j=i+k-1;
       int min=Integer.MAX_VALUE;
       Arrays.sort(nums);
       while(j<nums.length){
         min=Math.min(nums[j]-nums[i],min);
       i++;
       j++;
       }
       return min;
    }
}