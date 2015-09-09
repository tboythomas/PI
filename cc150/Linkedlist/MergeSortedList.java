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
public class MergeSortedList {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */

    // note:
    // Need a ListNode to hold the whole list! Use other runner to change the list that the head holds.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null){
    		return l2;
    	}else if (l2 == null){
    		return l1;
    	}
    	// give a new head
    	ListNode fakehead = new ListNode(0);
    	ListNode result = fakehead;
    	while(l1 != null && l2 != null){
    		if(l1.val < l2.val){
    			result.next = l1;
    			l1 = l1.next;
    		}else{
    			result.next = l2;
    			l2 = l2.next;
    		}
    		result = result.next;
    	}
    	if(l1 != null){
    		result.next = l1;
    	}
    	if(l2 != null){
    		result.next = l2;
    	}
    	return fakehead.next;
    }
}
