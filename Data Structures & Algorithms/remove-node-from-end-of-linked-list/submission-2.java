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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l=1;
        ListNode dum = head;
        while(dum.next!=null){
            dum=dum.next;
            l++;
        }
        n=l-n;
        if(n==0) return head.next;
        int ind=0;
        ListNode temp = head;
        ListNode prev=head;
        for(int i=1;i<=l;i++){
            if(i==n){
                temp.next = temp.next.next;
            }
            if(i!=l) temp = temp.next;
        }
        return head;
    }
}
