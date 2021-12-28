/*
December 28th 2021

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode h = head;
        int count = 0;
        
        while (h != null) {
            count++;
            h = h.next;
        }
        
        count = count / 2;
        int count2 = 0;
        
        h = head;
        while (count2 != count) {
            count2++;
            h = h.next;
        }
        
        return h;
    }
}
