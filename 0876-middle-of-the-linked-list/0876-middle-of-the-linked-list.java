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
    public ListNode middleNode(ListNode head) {
         ListNode slow=head;//
                            //Initially Both slow and fast pointers are pint to the head means first node
         ListNode fast=head;//
         while(fast!=null && fast.next!=null){
            slow=slow.next;// slow move by 1  node
            fast=fast.next.next;// fast move by 2 nodes;
         }
         return slow;
    }
}