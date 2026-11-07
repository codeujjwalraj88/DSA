class Solution {
    public int myAtoi(String s) {
       int num=0;


        s = s.trim();int sign=1;
         int i=0;
        if(s.length()==0)
        return 0;
        if(s.charAt(0)=='-'){
            sign=-1;
            i++;
            
        }else{ if(s.charAt(0)=='+'){
            i++;
        }
            
        }
     
      while(i<s.length()&&Character.isDigit(s.charAt(i))){
              int digit = s.charAt(i) - '0';
             if (num > Integer.MAX_VALUE / 10 ||
                (num == Integer.MAX_VALUE / 10 && digit > 7)) {
                 return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
               }

              
            
                num=num*10+(s.charAt(i)-'0');
                i++;
      }
      
           return sign*num;

        

      
    }
}