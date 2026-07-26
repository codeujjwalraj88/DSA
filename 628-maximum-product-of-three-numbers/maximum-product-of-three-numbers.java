class Solution {
    public int maximumProduct(int[] nums) {
      Arrays.sort(nums);
      int n=nums.length;
      int max=nums[n-1]*nums[n-2]*nums[n-3];
      if(nums[0]<0&&nums[1]<0){
         max=Math.max(nums[0]*nums[1]*nums[n-1],max);
      }

      return max;
      
    }
  
}