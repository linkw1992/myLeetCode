//
// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//
//
// Note: Do not modify the linked list.
//
//
// Follow up:
// Can you solve it without using extra space?
//


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)return null;
        ListNode A=head;
        ListNode B=head;
        ListNode p=head;
        while(B.next!=null && B.next.next!=null){
            A=A.next;
            B=B.next.next;
            if(A==B){
        while(B!=p){
            p=p.next;
            B=B.next;                
            }
                return p;
        }

            
        }
            return null;
    }
}
