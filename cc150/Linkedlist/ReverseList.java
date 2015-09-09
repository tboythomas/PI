public class ReverseList {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */

    // note:
    // Attention:
   	// ListNode result = head; result.next = null (head.next will be null as well, store first and then modify)
    // Reverse: create a newlist store the first node, then iterate through the list, add each node at the front	
    // of the new list. (1 -> 3 -> 2, new list: 1 -> null, reverse: 3->1, reverse again: 2 ->3 -> 1)
    public ListNode reverse(ListNode head) {
    	if(head == null || head.next == null){
    		return head;
    	}
    	ListNode result = head;
    	head = head.next;
    	result.next = null;
    	while(head != null){
    		ListNode temp = head;
    		head = head.next;
    		temp.next = result;
    		result = temp;
    	}
    	return result;
    }
}

