class Solution {
    public int arraySign(int[] nums) {
      int neg=0;
      int pos=0;
       for(int x:nums){
              if(x==0){
                return 0;
              }
              else if(x>0){
                pos++;
              }else{
                neg++;
              }
       }
       if(neg%2!=0){
        return -1;
       }
      return 1;
    }
}