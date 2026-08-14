class Solution {
    static boolean isvalid(String str){
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        for(Integer value:map.values()){
            if(value>2){return false;}
        }
        return true;
    }
    public int maximumLengthSubstring(String s) {
        int maxcount=0;
       for(int i=0;i<s.length();i++){
        for(int j=i;j<s.length();j++){
            String sub=s.substring(i,j+1);
            if(isvalid(sub)){
                maxcount=Math.max(maxcount,sub.length());
            }
        }
       } 
       return maxcount;
    }
}