// Write a program to find the node at which the intersection of two singly linked lists begins.
//
// For example, the following two linked lists: 
//
// A:          a1 → a2
//                    ↘
//                      c1 → c2 → c3
//                    ↗            
// B:     b1 → b2 → b3
//
// begin to intersect at node c1.
//
// Notes:
//
// If the two linked lists have no intersection at all, return null.
// The linked lists must retain their original structure after the function returns. 
// You may assume there are no cycles anywhere in the entire linked structure.
// Your code should preferably run in O(n) time and use only O(1) memory.
//
//
//
// Credits:Special thanks to @stellari for adding this problem and creating all test cases.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=getlength(headA), lenB=getlength(headB);
        int Min=Math.abs(lenA-lenB);
        if(lenA>lenB)headA=lengthMove(headA, Min);
        if(lenA<lenB)headB=lengthMove(headB, Min);
        while(headA!=null){
            if(headA==headB)return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
        
    }
    private ListNode lengthMove(ListNode Long, int lenMinus){//两者差
        while(lenMinus>0){
            Long=Long.next;
            lenMinus--;
        }
        return Long;
        
    }
    private int getlength(ListNode A){
        int len=0;
        while(A!=null){
            A=A.next;
            len++;
        }
        return len;
    }
}
