class Solution {
    
    public int binaryGap(int n) {
        if(Integer.bitCount(n)<2){
            return 0;
        }
        String str=Integer.toBinaryString(n);
        
         int i=0;
         
         int max=0;
         while(i<str.length()){
            if(str.charAt(i)=='1'){
               int j=i+1;
                while(j<str.length()&&str.charAt(j)!='1'){
                    j++;
                }
                if(j<str.length()){
                             int dist=j-i;
                                 max=Math.max(dist,max);
                }
                
                i=j;
            }else{i++;
            }
            
         }
         return max;
    }
}