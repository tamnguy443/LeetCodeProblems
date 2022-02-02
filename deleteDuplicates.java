/*
Feb 2nd, 2022

Given the head of a sorted linked list, delete all duplicates such that each element 
appears only once. Return the linked list sorted as well.

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
    public ListNode deleteDuplicates(ListNode head) { 
        ListNode n = head; //pointer
        while(n != null) {
             
            if(n.next != null && n.val == n.next.val) {  
                
                while(n.next != null && n.val == n.next.val) {
                    n.next = n.next.next;   
                    
                }           
            }               
            n = n.next;          
        }
        return head;        
    }
}
