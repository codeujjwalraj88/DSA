class Solution {
    public long sumAndMultiply(int n) {
        String s=String.valueOf(n);
       long sum=0;
       long nums=0;
       for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(ch!='0'){
           nums=nums*10+(ch-'0');
           sum=sum+(ch-'0');
        }
       }
       return nums*sum;
    }
}