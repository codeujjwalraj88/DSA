class Solution {
    static boolean selfdevidingnumber(int n){
        int coppy=n;
        while(n>0){
          int lastdigit=n%10;
          if(lastdigit==0){
            return false;
          }
          if(coppy%lastdigit!=0){
            return false;
          }
          n/=10;
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer>list=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(selfdevidingnumber(i)){
                list.add(i);
            }
        }
           return list;
    }
}