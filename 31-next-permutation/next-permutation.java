class Solution {
    static int[] swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }
    static int[] reverse(int[] arr,int i,int j){
       
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return arr;
    }
    public void nextPermutation(int[] nums) {
        int pivot=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot=i;
                 break;
            }
           
        }
        if(pivot==-1){
              reverse(nums,0,nums.length-1);
              return;
        }
        for(int i=nums.length-1;i>pivot;i--){
            if(nums[i]>nums[pivot]){
                swap(nums,i,pivot);
                break;
            }
        }
        reverse(nums,pivot+1,nums.length-1);
    }
}