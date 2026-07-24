class Solution {
    public int rob(int[] nums) {
      if(nums.length==1){
        return nums[0];
      }
      int maxdp[]=new int[nums.length];
      maxdp[0]=nums[0];
      maxdp[1]=Math.max(nums[0],nums[1]);
      for(int i=2;i<nums.length;i++){
        maxdp[i]=Math.max(maxdp[i-2]+nums[i],maxdp[i-1]);
      }
      return maxdp[nums.length-1];

    }
}