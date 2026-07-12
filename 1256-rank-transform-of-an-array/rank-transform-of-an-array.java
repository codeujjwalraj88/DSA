
import java.util.*;
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int sorted[]=arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer,Integer>map=new HashMap<>();
       int rank=1;
       for(int nums:sorted){
        if(!map.containsKey(nums)){
            map.put(nums,rank);
            rank++;
        }
       }
       for(int i=0;i<arr.length;i++){
        arr[i]=map.get(arr[i]);
       }
               return arr;
    }
}