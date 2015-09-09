public class MergeKSortedLists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */

    // note: review problem: MergeTwoLists
    // merge two list each time, and then return the result
    public ListNode mergeKLists(List<ListNode> lists) {  
        if(lists == null || lists.size()  == 0){
        	return null;
        }
        ListNode result = lists.get(0);
        for(int i = 1; i < lists.size(); i++){
        	result = mergeTwoLists(result, lists.get(i));
        }
        return result;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2){
    	ListNode head = new ListNode(-1);
    	ListNode runner1 = list1;
    	ListNode runner2 = list2;
    	ListNode current = head;
    	while(runner1 != null && runner2 != null){
    		if(runner1.val < runner2.val){
    			current.next = runner1;
    			runner1 = runner1.next;
    		}else{
    			current.next = runner2;
    			runner2 = runner2.next;
    		}
    		current = current.next;
    	}
    	if(runner1 != null){
    		current.next = runner1;
    	}
    	if(runner2 != null){
    		current.next = runner2;
    	}
    	return head.next;
    }
}

