public class ReorderList {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    
    //note: 1. seprate the list into two lists(seprate at the middle)
    //		2. reverse the right part list
    //      3. insert the right part node into the left part
    public void reorderList(ListNode head) {  
    	if(head == null || head.next == null || head.next.next == null){
    		return;
    	}
    	// seprate the list from the middle
    	ListNode slow = head;
    	ListNode fast = head;
    	while(fast.next != null && fast.next.next != null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	ListNode left = head;
    	ListNode right= slow.next;
    	slow.next = null;
    	// reverse the right list
     	ListNode current = right;
    	right = right.next;
    	current.next = null;
    	while(right != null){
    		ListNode temp = right;
    		right = right.next;
    		temp.next = current;
    		current = temp;
    	}
    	//merge two lists together
    	ListNode runner = left;
    	ListNode runner2 = current;
    	while(runner != null && runner2 != null){
    		ListNode temp1 = runner.next;
    		ListNode temp2 = runner2.next;
    		runner.next = runner2;
    		runner2.next = temp1;
    		runner = temp1;
    		runner2 = temp2;
    	}
    }
}

