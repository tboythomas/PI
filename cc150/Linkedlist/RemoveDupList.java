/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RemoveDupList {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */

    // note: if contains, skip that val, else keep iterating
    // use a hashset to store the all element.
    // metho 2: use two runner. (keep one at front, the other one iterate the list, skip the dups)
    public static ListNode deleteDuplicates(ListNode head) { 
    	if(head == null){
    		return head;
    	}
    	ListNode temp = head;
    	HashSet<Integer> counter = new HashSet<Integer>();
    	while(head.next != null){
    		if(!counter.contains(head.next.val)){
    			counter.add(head.next.val);
    		}else{
    			head.next = head.next.next;
    		}
    		head = head.next;
    	}
    	return temp;
    }  
}
