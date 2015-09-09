// Cycle I check if there is a cycle
public class ListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast.val == slow.val){
                return true;
            }
        }
        return false;
    }
}

// ---------------Cycle II. return the where the cycle starts
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
public class CycleII {
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // this expression checks the head as well
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast== slow){
                 break;
            }
        }
        // there is no cycle
        if(fast == null || fast.next == null){
            return null;
        }
        fast = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
}