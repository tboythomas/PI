public class RotateList {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    //note: 
    // move one node from the end to the front each time, use a counter to keep tracking.
    // Need to reset the head every time after rotating.
    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null || k == 0){
    		return head;
    	}
    	int counter = 0;
		while(counter < k){
	    	ListNode runner = head;
	    	counter++;
	    	// corner case: 1-> null, need to check both runner.next and runner.next.next
			while(runner.next != null && runner.next.next != null){
				runner = runner.next;
			}
			// corner case: 1 -> null, if list is like 1-> null, return itself since rotation doesnt change itself.
			if(head.next != null){
			    ListNode temp = runner.next;
			    runner.next = null;
			    temp.next = head;
			    head = temp;
			}
		}
		return head;
    }
}
