class Solution {
    public int reverseDegree(String s) {
        int ans=0;
        Map<Character,Integer>map=new HashMap<>();
       for(char ch='a';ch<='z';ch++){
          map.put(ch,'z'-ch+1);
       } 
       for(int i=0;i<s.length();i++){
         int index=i+1;
         ans=ans+index*map.get(s.charAt(i));
       }
       return ans;
    }
}