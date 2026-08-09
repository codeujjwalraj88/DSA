
import java.util.*;
class Solution {
    static List<List<Integer>> allsubsets(int arr[],List<Integer> list,int i){
        List<List<Integer>>ans=new ArrayList<>();
        if(i==arr.length){
            ans.add(new ArrayList<>(list));
            return ans;
        }
        //yes choise 
        list.add(arr[i]);
        ans.addAll(allsubsets(arr,list,i+1));
        list.remove(list.size()-1);

        //no choise
         ans.addAll(allsubsets(arr,list,i+1));
        return ans;


    }
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> mainlist=allsubsets(nums,new ArrayList<Integer>(),0);
        return mainlist;
    }
}