/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer>list=new ArrayList<>();
        List<Integer>criticals=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        if(list.size()==2){
            return new int[]{-1,-1};
        }
        for(int i=1;i<list.size()-1;i++){
              if(list.get(i-1)>list.get(i)&&list.get(i)<list.get(i+1)){
                      criticals.add(i+1);
              }
               if(list.get(i-1)<list.get(i)&&list.get(i)>list.get(i+1)){
                      criticals.add(i+1);
              }
        }
         if (criticals.size() < 2) {
               return new int[]{-1, -1};
           }
       // Collections.sort(criticals);
        int[] arr=new int[2];
      // Critical points are already in sorted order 
       int minDistance = Integer.MAX_VALUE; 
       for (int i = 1; i < criticals.size(); i++) { 
        minDistance = Math.min( minDistance, criticals.get(i) - criticals.get(i - 1) ); 
        }
         int maxDistance = criticals.get(criticals.size() - 1) - criticals.get(0);
          return new int[]{minDistance, maxDistance};
    }
}