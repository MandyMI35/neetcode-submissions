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
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;
        if(l2==null) return;
        l2 = reverse(l2);
        ListNode dum = l1;
        while(l1!=null && l2!=null){
            fast = l1.next;
            slow = l2.next;
            l1.next = l2;
            l2.next = fast;
            l1=fast;
            l2=slow;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode next = new ListNode();
        ListNode curr = head;
        ListNode prev = null;
        while(curr.next!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next=prev;
        return curr;
    }
}
