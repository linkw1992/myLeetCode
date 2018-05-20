//
// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//
//
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//
// Follow up:
// Could you do both operations in O(1) time complexity?
//
// Example:
//
// LRUCache cache = new LRUCache( 2 /* capacity */ );
//
// cache.put(1, 1);
// cache.put(2, 2);
// cache.get(1);       // returns 1
// cache.put(3, 3);    // evicts key 2
// cache.get(2);       // returns -1 (not found)
// cache.put(4, 4);    // evicts key 1
// cache.get(1);       // returns -1 (not found)
// cache.get(3);       // returns 3
// cache.get(4);       // returns 4
//
//


class LRUCache {
    Map<Integer,DLinkNode>map;
    DLinkNode head=null;
    DLinkNode tail=null;
    int capacity;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DLinkNode targ=map.get(key);
            targ.upDate();
            return targ.value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLinkNode targ=map.get(key);
            targ.value=value;
            targ.upDate();
        }else{
            if(capacity==0)return;
            if(map.size()==capacity){map.remove(head.key);
            head.removeFromHead();}
            DLinkNode newNode=new DLinkNode(key,value);
            newNode.append();
            map.put(key,newNode);
        }
    }
    class DLinkNode{//class can include class
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
        public DLinkNode(int key,int value){
            this.key=key;
            this.value=value;
        }
        void removeFromHead(){//from left to right
            if(tail==this){
                head=null;
                tail=null;
            }
            else{
                head=this.next;
                head.prev=null;
            }
        }
        void upDate(){
            if(tail==this)return;
            if(head!=this){
                this.prev.next=this.next;
            }
            else head=this.next;
            this.next.prev=this.prev;//important
            this.append();
        }
        void append(){//insert as tail
           if(tail==null){
               head=this;
               tail=this;
           }else{
               this.next=null;
               this.prev=tail;
               tail.next=this;
               tail=this;
           }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
