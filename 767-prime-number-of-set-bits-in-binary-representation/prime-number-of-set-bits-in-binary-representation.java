class Solution {
    public static int  countset(String str){
         int count=0;
        for(int i=0;i<str.length();i++){
             if(str.charAt(i)=='1'){
                count++;
             }
        }
        return count;
    }
    public static boolean isprime(int num){
        if(num<=1){
            return false;
        }
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        for(int i=left;i<=right;i++){
          if(isprime(countset(Integer.toBinaryString(i)))){
            ans++;
          }
        }
        return ans;
    }
}