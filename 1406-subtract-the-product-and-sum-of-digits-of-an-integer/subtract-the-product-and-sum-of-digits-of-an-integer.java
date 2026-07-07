class Solution {
    public int subtractProductAndSum(int n) {
       int sum=0;
       int mull=1;
       while(n>0){
        int last_digit=n%10;
         sum=sum+last_digit;
         mull=mull*last_digit;
         n=n/10;
        
       }
       return mull-sum;
    }
}