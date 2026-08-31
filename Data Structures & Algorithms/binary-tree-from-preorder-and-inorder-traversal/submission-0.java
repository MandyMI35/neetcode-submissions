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
    HashMap<Integer, Integer> indc = new HashMap<>();
    int preidx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++) indc.put(inorder[i],i);
        return dfs(preorder,0,preorder.length-1);
    }
    public TreeNode dfs(int[] preorder, int l, int r){
        if(l>r)return null;
        int rootv = preorder[preidx++];
        TreeNode root = new TreeNode(rootv);
        int mid = indc.get(rootv);
        root.left = dfs(preorder,l,mid-1);
        root.right = dfs(preorder,mid+1,r);
        return root;
    }
}
