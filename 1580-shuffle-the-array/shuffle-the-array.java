class Solution {
    public int[] shuffle(int[] nums, int n) {
        int s_index=0;
        int end=nums.length-n;
        int arr[]=new int[nums.length];
      for(int i=0;i<arr.length;i+=2){
          arr[i]=nums[s_index];
          s_index++;
      }
      for(int j=1;j<arr.length;j+=2){
          arr[j]=nums[end];
          end++;
      }
      return arr;
    }
}