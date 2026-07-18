class Solution {
    public int findGCD(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        for(int i=0;i<nums.length;i++){
            max=Integer.max(max,nums[i]);
            min=Integer.min(min,nums[i]);
        }
        while(max!=0){
            int temp=max;
            max=min%max;
            min=temp;
        }
           return min;
    }
}