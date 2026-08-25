class Solution {
    public int[] singleNumber(int[] nums) {
    Map<Integer,Integer>map=new HashMap<>();
    for(int i:nums){
        map.put(i,map.getOrDefault(i,0)+1);
    }
  List<Integer>list=new ArrayList<>();
    for(Integer num:map.keySet()){
        if(map.get(num)==1){
          list.add(num);
        }
    }
    int[] arr=new int[list.size()];
    for(int i=0;i<arr.length;i++){
        arr[i]=list.get(i);
    }
        return arr;
    }
}