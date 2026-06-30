class Solution {
    public int findDuplicate(int[] nums) {
    //Arrays.sort(nums);
    //for(int i=0;i<nums.length-1;i++){
    //    if(nums[i]==nums[i+1]){
    //        return nums[i];
    //    }
    //}
    //     return -1;
       HashMap<Integer,Integer>map=new HashMap<>();
       for(int x :nums){
        map.put(x,map.getOrDefault(x,0)+1);

       }
       for (int key : map.keySet()) {
          if (map.get(key) >= 2) {
                  return key;
              }
         }
         return -1;
    }
}