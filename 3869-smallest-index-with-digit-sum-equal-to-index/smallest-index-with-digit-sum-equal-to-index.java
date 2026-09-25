class Solution {
    static int sumofdigits(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int sum=sumofdigits(nums[i]);
            if(i==sum) return i;
        }
        return -1;
    }
}