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
 import java.util.*;
class Solution {
    List<List<Integer>>mainlist=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
       Queue<TreeNode>q=new LinkedList<>();
       if(root==null){return mainlist;}

         q.add(root);
         q.add(null);

         while(!q.isEmpty()){
            TreeNode curr=q.remove();
            if(curr==null){
                mainlist.add(list);
                list=new ArrayList<>();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                list.add(curr.val);
               if(curr.left!=null){
                q.add(curr.left);
               }
               if(curr.right!=null){
                q.add(curr.right);
               }

            }
         }
         return mainlist;
    }
}