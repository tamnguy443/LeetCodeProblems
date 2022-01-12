/*
January 11th 2022

You are given the root node of a binary search tree (BST) and a value to insert into the tree. 
Return the root node of the BST after the insertion. It is guaranteed that the new value does 
not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains 
a BST after insertion. You can return any of them.

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        /* If the tree is empty,
           return a new node */
        if (root == null) 
        {
            root = new TreeNode(val);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (val < root.val)
            root.left = insertIntoBST(root.left, val);
        else if (val > root.val)
            root.right = insertIntoBST(root.right, val);

        /* return the (unchanged) node pointer */
        return root;        
    }
}
