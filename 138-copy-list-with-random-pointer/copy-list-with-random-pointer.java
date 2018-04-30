//
// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
//
//
// Return a deep copy of the list.
//


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)return head;
        RandomListNode pp=head;
        Map<RandomListNode, RandomListNode> newMap=new HashMap<RandomListNode, RandomListNode>();
        while(pp!=null){
            newMap.put(pp,new RandomListNode(pp.label));
            pp=pp.next;
        }
        pp =head;
        while(pp!=null){
            (newMap.get(pp)).next=newMap.get(pp.next);
            (newMap.get(pp)).random=newMap.get(pp.random);
            pp=pp.next;
        }
      return newMap.get(head);
 
    }
}
