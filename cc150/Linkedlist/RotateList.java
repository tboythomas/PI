public class RotateList {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    // note: 
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
			// corner case: 1 -> null, if list is like 1-> null, 
			// return itself since rotation doesnt change itself.
			while(runner.next != null && runner.next.next != null){
				runner = runner.next;
			}
			if(head.next != null){
			    ListNode temp = runner.next;
			    runner.next = null;
			    temp.next = head;
			    head = temp;
			}
		}
		return head;
    }

    //optimization: if n > len, rotate n times = rotate n % len times.
    public ListNode rotateRight(ListNode head, int k){
    	if(head == null || head.next == null || k == 0){
    		return head;
    	}
    	int len = 0;
    	ListNode runner = head;
    	while(runner != null){
    		runner = runner.next;
    		len++;
    	}
    	int counter = 0;
    	runner = head;
    	// move to pointer to the right place
    	while(counter < len - k % len - 1){
    		runner = runner.next;
    		counter++;
    	}
    	// rotate
    	ListNode temp = runner.next;
    	// if k == len, temp is null, just return head, else rotate the list
    	if(temp != null){
        	runner.next = null;
        	runner = temp;
        	while(runner != null && runner.next != null){
        		runner = runner.next;
        	}
        	runner.next = head;
        	return temp;
    	}else{
    	    return head;
    	}
    }
}
