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
    public ListNode sortList(ListNode head) {
       
        ListNode temp=head;
        List<Integer>list=new ArrayList<>();
        while(temp!=null){
            list.add(temp.val);
             temp=temp.next;
        }
        Collections.sort(list);
        ListNode h=new ListNode(0);
        ListNode rare=h;
        for(int x : list){
            rare.next=new ListNode(x);
            rare=rare.next;
        }
        return h.next;
    }
}