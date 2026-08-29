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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        lvl(root,l,1);
        return l;
    }
    public void lvl(TreeNode root, List<List<Integer>> l, int ll){
        if(root==null) return;
        if(l.size()<ll) l.add(new ArrayList<>());
        l.get(ll-1).add(root.val);
        lvl(root.left,l,ll+1);
        lvl(root.right,l,ll+1);
    }
}
