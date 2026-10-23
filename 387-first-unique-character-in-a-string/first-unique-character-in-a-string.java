class Solution {
    public int firstUniqChar(String s) {
      for(int i=0;i<s.length();i++){
        char curr=s.charAt(i);
        if(s.indexOf(curr)==s.lastIndexOf(curr)){
            return i;
        }
      } 
      return -1; 
    }
}