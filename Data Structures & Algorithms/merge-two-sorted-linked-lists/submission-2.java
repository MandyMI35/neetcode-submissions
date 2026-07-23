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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null){return null;}
        if(list1==null){return list2;}
        if(list2==null){return list1;}
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode curr = new ListNode(0);
        ListNode t1=list1;
        ListNode t2=list2;
        while(t1!=null && t2!=null){
            if(t1.val<t2.val){
                curr.next=t1;
                t1=t1.next;
            }else{
                curr.next=t2;
                t2=t2.next;
            }
            if(head.val==Integer.MIN_VALUE){
                head=curr.next;
            }
            curr=curr.next;
        }
        if(t1!=null){
            curr.next=t1;
        }
        if(t2!=null){
            curr.next=t2;
        }
        return head;
    }
}