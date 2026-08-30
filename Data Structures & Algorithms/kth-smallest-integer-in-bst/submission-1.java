/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    List<Integer> l;
    public int kthSmallest(TreeNode root, int k) {
        l = new ArrayList<>();
        trv(root,k);
        return l.get(k-1);
    }
    public void trv(TreeNode root, int k){
        if(k==l.size() || root==null) return;
        trv(root.left,k);
        l.add(root.val);
        trv(root.right,k);
    }
}
