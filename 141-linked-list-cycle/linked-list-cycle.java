//
// Given a linked list, determine if it has a cycle in it.
//
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
    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        ListNode A=head;
        ListNode B=head;//Two pointers. Faster and Slower.
        while(B.next!=null && B.next.next!=null){
            A=A.next;
            B=B.next.next;
                if(A==B)
                return true;
        }
        return false;
    }
}
