/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class DeleteNodeList {
    public void deleteNode(ListNode node) {
 		if(node == null){
 			return;
 		}
	// if the node is not the end
 		if(node.next != null){
			int temp = node.next.val;
			node.val = temp;
			node.next = node.next.next; 		
    	}
    	else{
    	// if it is the end
        	node = null;
    	}
	}
}