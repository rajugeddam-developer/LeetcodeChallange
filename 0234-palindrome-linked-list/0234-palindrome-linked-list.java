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
    public boolean isPalindrome(ListNode head) {
       
     if(head == null || head.next == null) return true;

      //Find the middle node
      ListNode slow=head;
      ListNode fast=head;
      while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
      }

      //if the length is odd skip the middle one
      if(fast!=null){
        slow=slow.next;
      }

      //Reverse the second half
      ListNode prev=null;
      ListNode current=slow;

      while(current!=null){
        ListNode next=current.next;

        current.next=prev;
        prev=current;
        current=next;
      }

      //Compare the both beginings
      ListNode first=head;
      ListNode second=prev;
      while(second!=null){
        if(first.val!=second.val){
            return false;
        }
        first=first.next;
        second=second.next;
      }
      return true;
    }
}