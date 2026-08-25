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
    public boolean hasCycle(ListNode head) {
        if(head==null ) return false;
        HashSet<Integer> h = new HashSet<Integer>();
        ListNode curr = new ListNode();
        while(head.next!=null){
            if(h.contains(head.val)) return true;
            h.add(head.val);
            head=head.next;
        }
        return false;
    }
}
