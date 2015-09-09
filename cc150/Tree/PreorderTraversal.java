public class PreorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */


    // note:
    //      preorder: root, root.left, root.right
    //      inorder: root.left, root, root.right
    //      postorder: root.left, root.right, root

    //non-Recursion: (iterate) use a stack to store node that has been visited, however, since
    // its a preorder, so push the right node first, then left node(therefore when it pops, left node comes first)
    public ArrayList<Integer> preorderTraversal(TreeNode root){
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(root == null){
    		return result;
    	}
    	Stack<TreeNode> counter = new Stack<TreeNode>();
    	//push root
    	counter.push(root);
    	while(!counter.empty()){
    		TreeNode temp = counter.pop();
    		result.add(temp.val);
    		//push right node first
    		if(temp.right != null){
    			counter.push(temp.right);
    		}
    		if(temp.left != null){
    			counter.push(temp.left);
    		}
    	}
    	return result;
    }



    // Recursion 
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(root == null){
    		return result;
    	}
    	traversal(root, result);
    	return result;
    }
    // traversal, since we have one more variable result, we need this helper method
    public void traversal(ArrayList<Integer> result, TreeNode root){
    	if(root == null){
    		return;
    	}
    	result.add(root.val);
    	traversal(root.left, result);
    	traversal(root.right, result);
    }
}
