class Solution {
    public boolean isSumEqual(String firstword, String secondword, String targetword) {
        // Map<Character,Integer>map=new HashMap<>();
        // int k=0;
        //  for(char i='a';i<='z';i++){
        //   map.put(i,k++);
        // }
        // int first=0;
        // int second=0;
        // for(int i=0;i<firstword.length();i++){
        //   char curr=firstword.charAt(i);
        //       first=first*10+map.get(curr);
        // }
        // for(int i=0;i<secondword.length();i++){
        //   char curr=secondword.charAt(i);
        //       second=second*10+map.get(curr);
        // }
        // int target=0;
        // for(int i=0;i<targetword.length();i++){
        //   char curr=targetword.charAt(i);
        //       target=target*10+map.get(curr);
        // }
        //     if(first+second==target){return true;}return false;

        int first=0,second=0,target=0;
        for(char ch:firstword.toCharArray()){
            first=first*10+(ch-'a');
        }
         for(char ch:secondword.toCharArray()){
            second=second*10+(ch-'a');
        }
         for(char ch:targetword.toCharArray()){
            target=target*10+(ch-'a');
        }
        return first+second==target;
    }
}