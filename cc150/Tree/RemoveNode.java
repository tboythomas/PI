public class RemoveNode {
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    // note:
    public TreeNode removeNode(TreeNode root, int value) {
    	if(root == null){
    		return root;
    	}
    	if(value > root.val){
    		root.right = removeNode(root.right, value);
    	}else if(value < root.val){
    		root.left = removeNode(root.left, value);
    	}
    	// if the target node has two child
    	else if(root.left != null && root.right != null){
    		root.val = findmin(root.right).val;
    		root.right = removeNode(root.right, root.val);
    	}
    	// only one child
    	else{
    		root = (root.left == null)?root.right: root.left;
    	}
    	return root;
    }

    //find min (when delete a root node, replace it with either max on the left or min on the right)
    public TreeNode findmin(TreeNode root){
    	if(root == null){
    		return null;
    	}
    	else if(root.left == null){
    		return root;
    	}
    	// keep finding the min
    	return findmin(root.left);
    }
}