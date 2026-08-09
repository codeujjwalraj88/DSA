
import java.util.*;
class Solution {
     public static List<List<Integer>> allsubset(
            int arr[],
            List<Integer> list,
            int i,
            List<List<Integer>> ans) {

            if (i == arr.length) {
               ans.add(new ArrayList<>(list));
                return ans;
           }

              // YES choice
              list.add(arr[i]);
              allsubset(arr, list, i + 1, ans);
      
              // Backtrack
              list.remove(list.size() - 1);
      
              // NO choice
              allsubset(arr, list, i + 1, ans);

           return ans;
        }


    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> mainlist=allsubset(nums,new ArrayList<>(),0,new ArrayList<>());
        return mainlist;
    }

}