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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode slow= head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev= null;
        ListNode next = null;
        ListNode curr=slow;
        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode first=head, sec = prev;
        while(sec.next!=null){
            ListNode temp1 = first.next, temp2=sec.next;
            first.next = sec;
            sec.next = temp1;
            first=temp1;
            sec=temp2;
        }
    }
}
