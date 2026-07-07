import java.util.*;
class Solution {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
             int maxFreq = 0;
            int ans = -1;
            
            for (Integer key : map.keySet()) {
                if (map.get(key) > maxFreq) {
                    maxFreq = map.get(key);
                    ans = key;
                }
            }
            
         return ans;
    }
}