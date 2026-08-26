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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;
        ListNode head = new ListNode();
        ListNode dum = head;
        while(l1!=null || l2!=null || carry!=0){
            int v1 = l1==null ? 0 : l1.val;
            int v2 = l2==null ? 0 : l2.val;
            int n = v1 + v2 + carry;
            dum.next = new ListNode(n%10);
            carry = n/10;
            dum = dum.next;
            l1 = l1==null ? null : l1.next;
            l2 = l2==null ? null : l2.next;
        }
        return head.next;
    }
}
