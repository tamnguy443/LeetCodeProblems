/*
December 29th, 2021

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, 
just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //this is using breadth first traversal for binary tree
        
        /*using a queue
        Start from the root, insert the root into the Queue.
        Now while Queue is not empty,
        Extract the node from the Queue and insert all its children into the Queue.
        Print the extracted node.
        */
        if (root == null) {
            //if tree is null return nothing
            return null;
        }
        
        //insert the root into the Queue    
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        
        while (!q.isEmpty()) {
            int cnt = q.size();
            for (int i = 0;i < cnt; i++) {
                Node tempNode = q.poll();
                if (tempNode.left != null) q.add(tempNode.left);
                if (tempNode.right != null) q.add(tempNode.right);
                if (q.peek() != null && i < cnt -1) tempNode.next = q.peek();    
                //(i < cnt -1):To check the whether it's not the last element of a level
            }
        }
        
        return root;
    }
}
