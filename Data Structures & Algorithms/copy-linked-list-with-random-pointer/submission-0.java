/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        HashMap<Node, Node> h = new HashMap<>();
        Node curr = head;
        while(curr!=null){
            h.put(curr, new Node(curr.val));
            curr= curr.next;
        }
        curr = head;
        while(curr!=null){
            Node copy = h.get(curr);
            copy.next = h.get(curr.next);
            copy.random = h.get(curr.random);
            curr = curr.next;
        }
        return h.get(head);
    }
}
