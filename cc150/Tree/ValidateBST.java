public class ValidateBST {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */

    // note: read the wrong solution.
    // use in order traversal.(need a global varaible pre to hold previous treenode)
    // then check for the left subtree, and then the current root (if valid, update the current node)
    // and check for the right subtree	
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
    	if(root == null){
    		return true;
    	}
    	// check the left subtree first
    	if(!isValidBST(root.left)){
    		return false;
    	}
    	// check the root, must state that pre is not null
    	if(pre != null && pre.val >= root.val){
    		return false;
    	}
    	// if both left tree and current root is valid, update the pre
    	pre = root;
    	// check for the right subtree
    	return isValidBST(root.right);
    }
}

    
    /* Wrong code example, why wrong ? only consider current root and current root.left and root.right, didnt
       consider previous root.val
    public boolean isValidBST(TreeNode root) {
    	if(root== null){
    		return true;
    	}
    	else if(root.left != null && root.left.val > root.val){
    		return false;
    	}
    	else if(root.right != null && root.right.val < root.val){
    		return false;
    	}
    	return isValidBST(root.left) && isValidBST(root.right);
    }
    */

    // space cost: O(n)
    // note: use one extra linkedlist to store vals in the tree.(in order)
    // then iterate through the list and compare its val
    /* 
    List<Integer> list = new ArrayList<Integer>();  
      
    public boolean isValidBST(TreeNode root) {  
        if (root == null) return true;  
        if (root.left == null && root.right == null) return true;  
        inOrderTraversal(root);  
        for (int i = 1; i < list.size(); i++) {  
            if (list.get(i) <= list.get(i - 1)) return false;  
        }  
        return true;  
     }  
      
    public void inOrderTraversal(TreeNode root) {  
        if (root == null) return;  
        inOrderTraversal(root.left);  
        list.add(root.val);  
        inOrderTraversal(root.right);  
    }  
	*/