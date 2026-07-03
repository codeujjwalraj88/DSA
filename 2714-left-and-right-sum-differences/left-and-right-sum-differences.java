class Solution {
    public int[] leftRightDifference(int[] nums) {
         int lsum=0;int rsum=0;
         int ans[]=new int[nums.length];
       
        int leftsum[]=new int[nums.length];
        int rightsum[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            leftsum[i]=lsum;
            lsum=lsum+nums[i];
            
        }
        for(int i=nums.length-1;i>=0;i--){
            rightsum[i]=rsum;
            rsum=rsum+nums[i];
            

        }
        for(int i=0;i<nums.length;i++){
            ans[i]=Math.abs(leftsum[i]-rightsum[i]);
        }
        return ans;
    }
}