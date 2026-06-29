class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        Arrays.sort(nums);
        int max=0;
         int diff=0;
        for(int i=0;i<nums.length-1;i++){
             diff=Math.abs(nums[i]-nums[i+1]);
            if(diff>max){
                max=diff;
            }
        }
        return max;
    }
}