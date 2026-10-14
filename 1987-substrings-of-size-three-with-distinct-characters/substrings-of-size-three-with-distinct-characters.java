class Solution {
    static boolean isunique(String str){
       int i=0,j=1,k=2;
       if(str.charAt(i)!=str.charAt(j)&&str.charAt(i)!=str.charAt(k)&&str.charAt(j)!=str.charAt(k)){
        return true;
       }
       return false;
    }
    public int countGoodSubstrings(String s) {
     int i=0;
     int j=i+3;
     int count=0;
     
     List<String>list=new ArrayList<>();
     while(j<=s.length()&&i<=s.length()){
         list.add(s.substring(i,j));
         i++;
         j++;
         }
    for(String str:list){
        if(isunique(str)){count++;}
    } 
    return count;  
    }
    
}