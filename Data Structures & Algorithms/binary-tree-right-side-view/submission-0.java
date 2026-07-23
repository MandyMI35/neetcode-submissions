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
    public void list(TreeNode root, List<List<Integer>> l, int lvl){
        if(root==null){
            return;
        }
        if(lvl==l.size()){
            l.add(new ArrayList<>());
        }
        list(root.left,l,lvl+1);
        l.get(lvl).add(root.val);
        list(root.right,l,lvl+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        list(root,l,0);
        List<Integer> l1 = new ArrayList<>();
        for(int i=0;i<l.size();i++){
            l1.add(l.get(i).get(l.get(i).size()-1));
        }
        return l1;
    }
}
