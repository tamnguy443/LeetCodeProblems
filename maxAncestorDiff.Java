/*
December 31st 2021

Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.

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
    public int maxAncestorDiff(TreeNode root, int ancestor_min, int ancestor_max) {
        if (root != null) 
            return Math.max(maxAncestorDiff(root.left, Math.min(root.val, ancestor_min), Math.max(root.val, ancestor_max)),
                   maxAncestorDiff(root.right, Math.min(root.val, ancestor_min), Math.max(root.val, ancestor_max)));
        else 
            return ancestor_max - ancestor_min;
    }

    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, 100000, 0);
    }
    
}
/*
ancestor_min: the minimum val of the path from global root to current root
ancestor_max: the maximum val of the path from global root to current root
Not as easy to understand as Bottom-Up, you may need to spend some time, but it's really concise and elegant.
Note that when the function is recursive, the expression of the function parameter will be executed first, 
until the innermost recursive function starts to calculate the return value, and returns the outer return value layer by layer.
In the diagram, the parameter calculation will be performed along the red line first, and then returned layer by layer along 
the blue line. When each layer returns, the returned results of the left and right subtrees are merged through max.
*/
