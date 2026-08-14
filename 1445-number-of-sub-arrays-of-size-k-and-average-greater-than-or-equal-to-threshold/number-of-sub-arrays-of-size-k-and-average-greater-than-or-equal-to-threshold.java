class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int i=0;
        int j=i+k-1;
        int count=0;
        while(i<arr.length&&j<arr.length){
            int sum=0;
            for(int l=i;l<=j;l++){
              sum+=arr[l];
            }
            double avg=(double)sum/k;
            if(avg>=threshold){
                count++;
            }
            i++;
            j++;
        }
        return count;
    }
}