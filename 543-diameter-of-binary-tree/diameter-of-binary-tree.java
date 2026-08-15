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
    static int height(TreeNode root){
        if(root==null){
            return 0;
        }

        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
    static int diameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int ld=diameter(root.left);
        int lh=height(root.left);
        int rd=diameter(root.right);
        int rh=height(root.right);
        int selfdiameter=lh+rh;
        return Math.max(selfdiameter,Math.max(ld,rd));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root);
    }
}