/*
April 19th 2022

You are given the root of a binary search tree (BST), 
where the values of exactly two nodes of the tree were swapped by mistake. 
Recover the tree without changing its structure.

Example 1:
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

Example 2:
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.

*/
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
    public void recoverTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        outerloop:
        while (!queue.isEmpty()) {

            TreeNode tempNode = queue.poll();
            //System.out.print(tempNode.val + " ");
            if(tempNode.right != null && tempNode.left != null &&
               tempNode.right.val < tempNode.left.val) {
                int a = tempNode.left.val;
                tempNode.left.val = tempNode.right.val;
                tempNode.right.val = a;
                
                break outerloop;
            }
 
            /*Enqueue left child */
            if (tempNode.left != null) {
                
                Queue<TreeNode> queueL = new LinkedList<TreeNode>();
                queueL.add(tempNode.left);
        
                while (!queueL.isEmpty()) {

                TreeNode tempNodeL = queueL.poll();

                if(tempNodeL.val > tempNode.val) {
                    
                    TreeNode temp = new TreeNode(tempNode.val);
                    tempNode.val  = tempNodeL.val;
                    tempNodeL.val = temp.val;
                    
                    break outerloop;
                }
 
                /*Enqueue left child */
                if (tempNodeL.left != null) {
                
                queueL.add(tempNodeL.left);
                }
            
                /*Enqueue right child */
                if (tempNodeL.right != null) {

                queueL.add(tempNodeL.right);
                }
            }            
                
                queue.add(tempNode.left);
            }
            
            /*Enqueue right child */
            if (tempNode.right != null) {
                                
                Queue<TreeNode> queueR = new LinkedList<TreeNode>();
                queueR.add(tempNode.right);
        
                while (!queueR.isEmpty()) {

                TreeNode tempNodeR = queueR.poll();

                if(tempNodeR.val < tempNode.val) {
                    
                    TreeNode temp = new TreeNode(tempNode.val);
                    tempNode.val  = tempNodeR.val;
                    tempNodeR.val = temp.val;
                    
                    break outerloop;
                }
 
                /*Enqueue left child */
                if (tempNodeR.left != null) {
                
                queueR.add(tempNodeR.left);
                }
            
                /*Enqueue right child */
                if (tempNodeR.right != null) {

                queueR.add(tempNodeR.right);
                }
            }

                queue.add(tempNode.right);
            }
        }        
        
        
    }
}
