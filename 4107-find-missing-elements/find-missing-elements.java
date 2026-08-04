class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer>list=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int num:nums){
            list.add(num);
        }
        for(int i=nums[0];i<nums[nums.length-1];i++){
            if(!list.contains(i)){
                ans.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    
    
    }
}