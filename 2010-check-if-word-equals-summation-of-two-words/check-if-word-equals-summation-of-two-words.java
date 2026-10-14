class Solution {
    public boolean isSumEqual(String firstword, String secondword, String targetword) {
        Map<Character,Integer>map=new HashMap<>();
        int k=0;
         for(char i='a';i<='z';i++){
          map.put(i,k++);
        }
        int first=0;
        int second=0;
        for(int i=0;i<firstword.length();i++){
          char curr=firstword.charAt(i);
              first=first*10+map.get(curr);
        }
        for(int i=0;i<secondword.length();i++){
          char curr=secondword.charAt(i);
              second=second*10+map.get(curr);
        }
        int target=0;
        for(int i=0;i<targetword.length();i++){
          char curr=targetword.charAt(i);
              target=target*10+map.get(curr);
        }
            if(first+second==target){return true;}return false;
    }
}