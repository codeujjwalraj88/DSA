class Solution {
   static int digitmull(int n){
    int mull=1;
    while(n>0){
        int last=n%10;
        mull=mull*last;
        n/=10;
    }
    return mull;
   }

    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++){
            if(digitmull(i)%t==0){
                return i;
            }
        }
        return -1;
    }
}