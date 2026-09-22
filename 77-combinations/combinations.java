class Solution {
    static List<List<Integer>> subsets(int[] arr,List<Integer> list,List<List<Integer>> mainlist,int index,int k){
        if(index==arr.length){
            if(list.size()==k){
            mainlist.add(new ArrayList<>(list));
            }
            return mainlist;
        }
        list.add(arr[index]);
        subsets(arr,list,mainlist,index+1,k);
        list.remove(list.size()-1);
        subsets(arr,list,mainlist,index+1,k);

       return mainlist;
    }
    public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> list=new ArrayList<>();
   int[] arr=new int[n];
   for(int i=0;i<n;i++){
    arr[i]=i+1;
   }
        return subsets(arr,new ArrayList<>(),new ArrayList<>(),0,k);
    }
}