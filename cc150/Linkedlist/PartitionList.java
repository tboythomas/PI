public class PartitionList {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */

    // note: 
    // use two linkedlist, one is for the val that is less than X,
    // other one is for the val that is greater than X.
    // iterate through head, if val > X, put it on list_right, otherwise put it on list_left
    // 
    public ListNode partition(ListNode head, int x) {
    	if(head == null){
    		return head;
    	}
    	// dont forget to make a node that holds the list
    	ListNode fake_l = new ListNode(0);
    	ListNode fake_r = new ListNode(0);
    	ListNode current_l = fake_l;
    	ListNode current_r = fake_r;
    	while(head != null){
    		if(head.val < x){
    			current_l.next = head;
    			current_l = current_l.next;
    		}else{
    			current_r.next = head;
    			current_r = current_r.next;
    		}
    		head = head.next;
    	}
    	// mark the end of the right list, and then merge them together.
    	current_r.next = null;
    	current_l.next = fake_r.next;
    	return fake_l.next;
    }
}
