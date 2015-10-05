
// note:
// first get the length of the list, then use recursion to build the binary tree
// in order to make it balanced, the left tree has (size/2) nodes and the right 
// tree has(size - 1 - size/2) nodes
// need a global variable current to keep track of the change in list.
public class SortedListToBST {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    private ListNode current;
    public TreeNode sortedListToBST(ListNode head) {  
    	if(head == null){
    		return null;
    	}
    	if(head.next == null){
    		return new TreeNode(head.val);
    	}
    	int len = 0;
    	ListNode runner = head;
    	while(runner != null){
    		len++;
    		runner = runner.next;
    	}
    	ListNode current = head;
    	TreeNode root = makeBST(len);
    	return root;
    }

    public TreeNode makeBST(int len){
    	if(len == 0){
    		return null;
    	}

    	TreeNode left = makeBST(len/2);
    	TreeNode root = new TreeNode(current.val);
    	current = current.next;
    	TreeNode right = makeBST(len - 1 - len/2);

    	root.left = left;
    	root.right = right;
    	return root;
    }
}
