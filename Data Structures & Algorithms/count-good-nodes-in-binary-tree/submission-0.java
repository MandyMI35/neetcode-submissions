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
    public void path(TreeNode root, List<Integer> l,List<Integer> l2){
        if(root==null){
            return;
        }
        l.add(root.val);
        boolean f = true;
        for(int i=0;i<l.size();i++){
            if(l.get(i)>root.val){
                f=false;
                break;
            }
        }
        if(f==true){
            l2.add(root.val);
        }
        path(root.left,l,l2);
        path(root.right,l,l2);
        l.remove(l.size()-1);
    }
    public int goodNodes(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        path(root,l,l2);
        return l2.size();
    }
}
