class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
       Set<Integer> set1=new HashSet<>();
       Set<Integer> set2=new HashSet<>();
       for(int n:nums1){
        set1.add(n);
       } 
       int min = Integer.MAX_VALUE;

       for(int m:nums2){
        if(set1.contains(m)){
           min = Math.min(min, m);
        }
       }
       return min==Integer.MAX_VALUE ? -1:min;
    }
}