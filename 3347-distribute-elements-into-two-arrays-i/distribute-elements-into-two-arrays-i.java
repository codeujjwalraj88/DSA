class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer>left=new ArrayList<>();
        List<Integer>right=new ArrayList<>();
        left.add(nums[0]);
        right.add(nums[1]);
        for(int i=2;i<nums.length;i++){
         if(left.get(left.size()-1)>right.get(right.size()-1)){
            left.add(nums[i]);
         }else{
            right.add(nums[i]);
         }
        }
        int[] arr=new int[left.size()+right.size()];

        int k=0;
        for(int x:left){
            arr[k++]=x;
        }
        for(int x:right){
            arr[k++]=x;
        }
        return arr;
    }
}