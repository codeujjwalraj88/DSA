class Solution {
    static Set<List<Integer>> subsets(int[] arr,List<Integer> list,int index,Set<List<Integer>> set){
       
        if(index==arr.length){
            set.add(new ArrayList<>(list));
            return set;

        }
        list.add(arr[index]);
        subsets(arr,list,index+1,set);


        list.remove(list.size()-1);
        subsets(arr,list,index+1,set);

        return set;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        subsets(nums,new ArrayList<>(),0,set);
     List<List<Integer>> ans=new ArrayList<>(set);
     return ans;
    }
}