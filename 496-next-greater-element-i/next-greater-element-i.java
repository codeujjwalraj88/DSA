class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer>list=new ArrayList<>();
        for(int x : nums1){
            for(int i=0;i<nums2.length;i++){
                if(x==nums2[i]){
                    int index=i+1;
                    boolean found = false;
                    while(index<nums2.length){
                         if(nums2[index]>x){
                            list.add(nums2[index]);
                            found=true;
                            break;
                         }
                         index++;
                    }if(!found){
                        list.add(-1);
                    }
                }
            }
        }int ans[]=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
             ans[i] = list.get(i);
               }
               return ans;
    }
}