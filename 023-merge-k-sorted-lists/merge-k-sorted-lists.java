// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//
// Example:
//
//
// Input:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        if(lists.length==1)return lists[0];
        if(lists.length==2)return mergeTwoLists(lists[0], lists[1]) ;
        int mid=lists.length/2;
        ListNode[] sublist1=new ListNode[mid];
        ListNode[] sublist2=new ListNode[lists.length-mid]; 
        int i,j=0;
        for(i=0;i<mid;i++){
           sublist1[i]=lists[i];
        }
        for(i=mid;i<lists.length;i++){
            sublist2[j]=lists[i];j++;
        }
        ListNode l1=mergeKLists(sublist1);
        ListNode l2=mergeKLists(sublist2);
        return mergeTwoLists(l1, l2);
    }
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l=new ListNode(0);
        ListNode p=l;
        while( l1!=null && l2!=null){
            if(l1.val<l2.val){
                p.next=l1;
                l1=l1.next; 
            }
            else {
                p.next=l2;
                l2=l2.next; 
            }
            p=p.next;
            }

        
        if(l1!=null)p.next=l1;
        else if (l2!=null)p.next=l2;
        return l.next;
    }
}
