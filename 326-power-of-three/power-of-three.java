class Solution {
   
    public boolean isPowerOfThree(int n) {
      double ans=0;
    for(int i=0;i<Math.sqrt(n);i++){
      ans=Math.pow(3,i); 
      if(ans==n) return true;
    }
    return false;

     
    }
}