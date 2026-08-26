class Solution {
    public int[] findErrorNums(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        int[] arr=new int[2];
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int i:map.keySet()){
            if(map.get(i)==2){
            arr[0]=i;
            }
        }
        for(int i=1;i<=nums.length;i++){
            if(!map.containsKey(i)){
                arr[1]=i;
            }
        }
        return arr;
    }
}