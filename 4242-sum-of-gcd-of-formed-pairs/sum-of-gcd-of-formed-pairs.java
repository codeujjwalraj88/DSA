class Solution {
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;

        }
        return a;
    }
    public long gcdSum(int[] nums) {
         int arr[]=new int[nums.length];
         int gcdarr[]=new int[nums.length];
         int max=nums[0];
         for(int i=0;i<nums.length;i++){
             max=Math.max(max,nums[i]);
             arr[i]=max;
             gcdarr[i]=gcd(nums[i],arr[i]);
         }
         Arrays.sort(gcdarr);
         long sum=0;
         int i=0;
         int j=gcdarr.length-1;
         while(i<j){
            int num=gcd(gcdarr[i],gcdarr[j]);
            sum+=num;
            i++;j--;
         }

              return sum;
    }
}