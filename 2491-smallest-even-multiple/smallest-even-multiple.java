class Solution {
    public int smallestEvenMultiple(int n) {
        int ans=1;
        if(n%2!=0){
            ans=n*2;
        }else{
            ans=n;
        }
       return ans;
    }
}