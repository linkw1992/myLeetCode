// Reverse a linked list from position m to n. Do it in one-pass.
//
// Note: 1 ≤ m ≤ n ≤ length of list.
//
// Example:
//
//
// Input: 1->2->3->4->5->NULL, m = 2, n = 4
// Output: 1->4->3->2->5->NULL
//
//


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n==1)return head;
        ListNode pre=null;
        ListNode p=head;
        int i=m;
        while(i>1){
            pre=p;
            p=p.next;
            i--;}
            int len=n-m+1;
            ListNode newHead=null;
            ListNode tail=p;
            ListNode newTail=tail;
            while(len>0){
                ListNode cur=tail.next;
                tail.next=newHead;
                newHead=tail;
                tail=cur;
                len--;
        }
            if(tail!=null)newTail.next=tail;
            if(m==1)return newHead;
            else{
                pre.next=newHead;
                return head;}
    }

}
