class Solution {
    public int subarraySum(int[] nums, int k) {
        int i=0;
        int count=0;
        while(i<nums.length){
            int j=i;
            int sum=0;
            while(j<nums.length){
                sum+=nums[j];
                if(sum==k){
                    count++;
                }
                j++;
            }
            i++;
        }
        return count;
    }
}