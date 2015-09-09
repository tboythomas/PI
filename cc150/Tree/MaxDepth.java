public class Maxdepth{
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */

    //note: if node is null, return 0, else return its depth + 1
    public int maxDepth(TreeNode root) {
    	if(root == null){
    		return 0;
    	}
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	return Math.max(maxDepth(left) + 1, maxDepth(right) + 1);
    }
}