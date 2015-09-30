public class Populating {
/*

	  1
   2 ->  3
4 -> 5 -> 6 -> 7
*/
    public void connect(TreeLinkNode root) {
        if(root == null){
        	return;
        }
        TreeLinkNode start = root;
        while(start != null){
        	// traversal current level
        	TreeLinkNode current = start;
        	while(current != null){
        		// link 2 -> 3, 4-> 5 etc
        		if(current.left != null){
        		    current.left.next = current.right;
        		}
        		// link 5 -> 6 etc
        		if(current.right != null && current.next != null){
        			current.right.next = current.next.left;
        		}
        		current = current.next;
        	}
        	// go to next level
        	start = start.left;
        }
    }
}