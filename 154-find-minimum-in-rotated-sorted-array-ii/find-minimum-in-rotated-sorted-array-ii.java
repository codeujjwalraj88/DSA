class Solution {
    public int findMin(int[] nums) {
      List<Integer>list=Arrays.stream(nums)
                           .boxed()
                           .collect(Collectors.toList());  
    
     return Collections.min(list);
    
    }
}