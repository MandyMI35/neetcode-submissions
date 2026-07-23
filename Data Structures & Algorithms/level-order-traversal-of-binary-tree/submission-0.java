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
    public void list(TreeNode root,int lvl, List<List<Integer>> l){
        if(root==null){return;}
        if(l.size()==lvl){
            l.add(new ArrayList<>());
        }
        l.get(lvl).add(root.val);
        list(root.left,lvl+1,l);
        list(root.right,lvl+1,l);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        list(root,0,l);
        return l;
    }
}
