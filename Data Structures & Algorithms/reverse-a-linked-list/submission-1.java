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
    public ListNode rev(ListNode prev, ListNode curr, ListNode nxt){
        if(curr==null){
            return prev;
        }
        ListNode temp = new ListNode(0);
        curr.next=prev;
        if(nxt.next==null){
            nxt.next=curr;
            return nxt;
        }
        return rev(curr,nxt, nxt.next);
    }
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        return rev(null,head, head.next);
    }
}
