/*
December 30th 2021

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.


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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {        
        
        ListNode n = new ListNode();
        List<Integer> l = new ArrayList<Integer>();
        
        while(list1 != null) {
            l.add(list1.val);
            list1 = list1.next;
        }
        
        while(list2 != null) {
            l.add(list2.val);
            list2 = list2.next;
        }
        
        if(l.isEmpty()) {
            return list1;
        }
        
        Collections.sort(l);
//        System.out.println(l);
        n.val = l.get(l.size() - 1);
        for(int i = l.size() - 1; i > 0; i--) {
            ListNode temp = new ListNode(l.get(i - 1));
            temp.next = n;
            n = temp;
        }
        
        return n;
    }
}
