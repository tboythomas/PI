/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class RemoveNthNode{
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */

    // note:
    // iterate through the linkedlist, get the its length
    // iterate it again, skip the node when iterate on the node before the Nth Node
    ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode temp2 = head;
        int len = 0;
        while(temp2 != null){
            temp2 = temp2.next;
            len++;
        }
        if(len == n){
            return head.next;
        }
        int counter = 0;
        ListNode temp = head;
        while(temp != null){
            if(counter == len - n -1){
                temp.next = temp.next.next;
            }
            counter++;
            temp = temp.next;
        }
        return head;
    }
}
