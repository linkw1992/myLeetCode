// Given a singly linked list, determine if it is a palindrome.
//
// Follow up:
// Could you do it in O(n) time and O(1) space?


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null)slow=slow.next;//slow在中心位置的下一个！
        fast=head;
        slow=reverse(slow);
        while(slow!=null){
            if(fast.val!=slow.val)
            return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode cur=head.next;
            head.next=prev;
            prev=head;
            head=cur;
        }
        return prev;
    }
}
