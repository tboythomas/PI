public class BalancedBST {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */

    // note: Review AVL tree. Return the depth for each node at each level,
    // calculate the difference, if it is greater than 1, return true, else return false
    public boolean isBalanced(TreeNode root) {
        if(root == null){
        	return true;
        }
        if(Math.max(Depth(root.left) - Depth(root.right)) > 1){
        	return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int Depth(TreeNode root){
    	if(root == null){
    		return 0;
    	}
    	return Math.max(Depth(root.left) + 1, Depth(root.right) + 1);
    }
}
