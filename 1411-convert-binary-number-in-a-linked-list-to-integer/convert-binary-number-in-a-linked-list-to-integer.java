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
    public int getDecimalValue(ListNode head) {
        ListNode temp=head;
       // int num=0;
       // while(temp!=null){
       //     int digit=temp.val;
       //     num=num*10+digit;
       //     temp=temp.next;
//
       // }
       // 
       // return Integer.parseInt(String.valueOf(num),2);


        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}