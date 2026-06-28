class Solution {
    public int findKthPositive(int[] arr, int k) {
       List<Integer>list=new ArrayList<>();
       for(int i=1;i<10000;i++){
        list.add(i);
       }
       for(int i=0;i<arr.length;i++){
            if(list.contains(arr[i])){
                list.remove(Integer.valueOf(arr[i]));
            }
       }
       return list.get(k-1);
    }
}