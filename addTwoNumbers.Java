/*
December 26th, 2021

You are given two non-empty singly linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Input: l1 = [0], l2 = [0]
Output: [0]

*/

import java.math.BigInteger;
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        String list1 = "";
        String list2 = "";
        //take each list and add the integer into the coresponding string
        ListNode ls1 = l1;
        
        while(ls1 != null) {
            list1 = list1 + ls1.val + "";
            ls1 = ls1.next;
        }
//        System.out.println(list1);
        
        ListNode ls2 = l2;
        while(ls2 != null) {
            list2 = list2 + ls2.val + "";
            ls2 = ls2.next;
        }
//        System.out.println(list2);
        
        //reverse both strings
        StringBuilder input1 = new StringBuilder();
        input1.append(list1);
        input1.reverse();
        list1 = input1.toString();
//        System.out.println(list1);
        
        input1 = new StringBuilder();
        input1.append(list2);
        input1.reverse();
        list2 = input1.toString();
//        System.out.println(list2);
        
        //convert list1 and list2 from string to BigInt and then add them together
        //has to be BigInt because this questions gives some MASSIVE numbers
        BigInteger a = new BigInteger(list1);
        BigInteger b = new BigInteger(list2);
        BigInteger asb = a.add(b);
        //convert asb into string
        String answ = asb + "";
        
        //make a new list head node withe the FIRST index of answ
        ListNode ans = new ListNode(Integer.parseInt(answ.charAt(0) + ""));
        
        //loop through the rest of the string and fill in the next nodes
        for(int i = 1; i < answ.length(); i++) {
            //make new node for next index
            ListNode nextNode = new ListNode(Integer.parseInt(answ.charAt(i) + ""));
            /*
            This loop Inserts a new Node at front of the list.
            so the results will be in reverse with the last index of the string
            being the head of ListNode 
            */
            nextNode.next = ans;
            ans = nextNode;
        }
                
        return ans;
    }
}

