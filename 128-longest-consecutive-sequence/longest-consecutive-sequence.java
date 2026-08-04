class Solution {
    public int longestConsecutive(int[] nums) {
        
   TreeSet<Integer>ts=new TreeSet<>();
   for(int i:nums){
    ts.add(i);
   }
   if(ts.size()==0){
    return 0;
   }

   int max=1;
   List<Integer>list=new ArrayList<>(ts);
   int count=1;
   for(int i=1;i<list.size();i++){
     
     
     if(list.get(i)==list.get(i-1)+1){
        count++;
       
     }
     else{
        count=1;
       
     }
      max=Math.max(count,max);
    
       }
   



return max;
    }
}