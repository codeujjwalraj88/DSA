class Solution {
    private List<List<Integer>> allcombinationsum(int[] arr,int index,List<Integer> list,List<List<Integer>>ans,int target){
        if(index==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
                
            }
            return ans;
        }
        if(arr[index]<=target){
           list.add(arr[index]);
           allcombinationsum(arr,index,list,ans,target-arr[index]);
           list.remove(list.size()-1);
        }
        allcombinationsum(arr,index+1,list,ans,target);
        return ans;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        allcombinationsum(candidates,0,new ArrayList<>(),ans,target);
        return ans;

    }
}