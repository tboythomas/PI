public class SortList {
    /***
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */

    //  note: merge sort , separate the lists, and then megerge
    //  need to review merge sort. recursion to keep dividing!
    public ListNode sortList(ListNode head) {  
        if(head == null || head.next == null){
        	return head;
        }
        ListNode slow = separateList(head);
    	ListNode right = slow.next;
    	slow.next = null;
    	return mergeList(sortList(head), sortList(right));
    }
    
    public ListNode separateList(ListNode head){
        // separate the list into left and right from the middle
    	ListNode slow = head;
    	ListNode fast = head;
    	while(fast.next != null && fast.next.next != null){
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }
    
    public ListNode mergeList(ListNode left, ListNode right){
            	// merge
    	ListNode fake_head = new ListNode(-1);
    	ListNode current = fake_head;
    	while(left != null && right != null){
    		if(left.val < right.val){
    			current.next = left;
    			left = left.next;
    		}else{
    			current.next = right;
    			right = right.next;
    		}
    		current = current.next;
    	}  
        current.next = left != null? left:right;
    	return fake_head.next;
    }
}
