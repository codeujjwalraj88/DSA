class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        List<Integer>list=new ArrayList<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int size=nums.length/3;
        for(Integer x:map.keySet()){
            if(map.get(x)>size){
                list.add(x);
            }
        }
        return list;
    }
}