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
    public void list(TreeNode root, List<Integer> l){
        if(root==null){
            return;
        }
        list(root.left,l);
        l.add(root.val);
        list(root.right,l);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> l = new ArrayList<>();
        list(root,l);
        return l.get(k-1);
    }
}
