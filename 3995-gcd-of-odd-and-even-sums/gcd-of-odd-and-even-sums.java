class Solution {
    public int gcdOfOddEvenSums(int n) {
      //  return n;
      int sumodd=n*n;
      int sumeven=n*(n+1);
      while(sumodd!=0){
        int temp=sumodd;
        sumodd=sumeven%sumodd;
        sumeven=temp;
      }
      return sumeven;
    }
}