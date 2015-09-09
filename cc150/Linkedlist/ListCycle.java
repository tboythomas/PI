public class ListCycle {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    
    // note: if a list has cycle, use fast runner and slow runner to detect
    // if they meet, there is cycle. put slow runner back to the head, move each runner one step a time,
    // return the node thay they meet, that is where the cycle starts
    /*
	Prove:
		Assume point z is the point where fast and slow meet.(on the cycle)
		Slow: a + b
		Fast: a + b + c + b = 2(a+b)
		Conclusion: a = c
		http://blog.sina.com.cn/s/blog_6f611c300101fs1l.html
    */
    public boolean hasCycle(ListNode head) {  
    	if(head == null){
    		return false;
    	}
    	ListNode fast = head;
    	ListNode slow = head;
    	while(fast.next != null && fast.next.next != null){
    		slow = slow.next;
    		fast = fast.next.next;
    		if(slow.val == fast.val){
    			return true;
    		}
    	}
    	return false;
    }
}

