import java.util.*;
class Solution {
    static List<List<Integer>> allpermutation(int[] nums,List<Integer> list,List<List<Integer>> mainlist,boolean[] used){
        if(list.size()==nums.length){
            mainlist.add(new ArrayList<>(list));
            return  mainlist;
        }
        for(int i=0;i<nums.length;i++){
           if(used[i]){
            continue;
           }
           used[i]=true;
           list.add(nums[i]);
            allpermutation(nums,list,mainlist,used);
            list.remove(list.size()-1);
             
             used[i]=false;
        }
        return mainlist;
        
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        allpermutation(nums,new ArrayList<Integer>(),ans,new boolean[nums.length]);
        Set<List<Integer>> set=new HashSet<>(ans);
        List<List<Integer>> ans2=new ArrayList<>(set);
          return ans2;

    }
}