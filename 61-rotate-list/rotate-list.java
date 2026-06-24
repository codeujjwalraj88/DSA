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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp=head;
        List<Integer>list=new ArrayList<>();
        while(temp!=null){
           list.add(temp.val);
           temp=temp.next;
        }
        Collections.rotate(list, k);
        ListNode ll=new ListNode(0);
        ListNode current=ll;
        for(int x : list){
            current.next=new ListNode(x);
            current=current.next;
        }
        ListNode head1=ll.next;
        return head1;
    }
}