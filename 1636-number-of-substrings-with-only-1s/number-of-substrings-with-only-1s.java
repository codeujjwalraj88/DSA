class Solution {
    public int numSub(String s) {
         int i=0;
         int j=0;
         long mod=1000000007;
         long ans=1;
          while(i<s.length()){
                if(s.charAt(i)=='1'){
                     j=i;
                     while(j<s.length()&&s.charAt(j)=='1'){
                       j++;
                     }
                    long count=j-i;
                    ans =(ans+(count*(count+1)/2))%mod;
                    i=j;
                }else{i++;}
                 
            }
         return (int)ans-1;
            
       }
           
       
    
}