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
        if(l1.val==0 && l2.val==0){return l2;}
        int n=0;
        int num1=0;
        while(l1!=null){
            num1+=l1.val*Math.pow(10,n);
            l1=l1.next;
            n++;
        }
        n=0;
        int num2=0;
        while(l2!=null){
            num2+=l2.val*Math.pow(10,n);
            l2=l2.next;
            n++;
        }
        ListNode dummy = new ListNode(10);
        ListNode curr = dummy;
        int num3=num1+num2;
        if (num3==0){return new ListNode(10);}
        while(num3!=0){
            int dig = num3 % 10;
            curr.next = new ListNode(dig);
            curr=curr.next;
            num3/=10;
        }
        return dummy.next;
    }
}
