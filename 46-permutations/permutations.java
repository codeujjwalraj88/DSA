import java.util.*;
class Solution {
    static void permutations(int[] nums,List<Integer> list,boolean[] used,List<List<Integer>> ans){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])
                continue;
            
            used[i]=true;
            list.add(nums[i]);
            permutations(nums,list,used,ans);

            list.remove(list.size()-1);
            used[i]=false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
         permutations(nums,new ArrayList<Integer>(),new boolean[nums.length],ans);
         return ans;
    }
}