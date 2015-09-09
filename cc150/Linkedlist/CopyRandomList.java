/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyRandomList {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */

    // note: O(1) space 
    // first understand what deep copy(establish one indentical in memeory) is and shallow copy(create a pointer that points the existed item) is.
    // 1. double the list, copy each element. 1 -> 2 - > 3 become 1-> 1 -> 2 -> 2 -> 3 -> 3 
    // 2. connect their random node
    // 3. seprate the list into two identical lists.
    // another method: use a hashtable to store every node and its random node, then copy the list, then assign their random node.
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null){
    		return head;
    	}
    	// double the list
    	RandomListNode current = head;
    	RandomListNode next = null;
    	while(current != null){
    		next = current.next;
    		RandomListNode temp = new RandomListNode(current.label);
    		current.next = temp;
    		current.next.next = next;
    		current = current.next.next;
    	}
    	//assign random
    	current = head;
    	// length is always even, move 2 node each time, current.next is always un-null
 		while(current != null){
 			if(current.random != null){
 				current.next.random = current.random.next;
 			}
 			current = current.next.next;
 		}
 		// separate the list
 		RandomListNode result = null;
 		current = head;
 		RandomListNode runner = null; //modify result
 		while(current != null){
			// add the first node (head)			
 			if(result == null){
 				RandomListNode next2 = current.next.next;
 				result = current.next;
 				current.next = current.next.next;
 				current = current.next; 
 				runner = result;				
 			}
 			// add the rest node
 			else{
 				RandomListNode next2 = current.next.next;
 				runner.next = current.next;
 				current.next = current.next.next;
 				current = current.next;
 				runner = runner.next;
 			}
 		}
 		return result;
    }
}
