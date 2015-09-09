public class SearchRangeBST {
    /*
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */

    // note: 
    // if k2 < root.val, search the left sub tree, if k1 > root.val, search the right sub tree
    // else, in order to return a list with ascending order, do a inorder traversal.(left, root, right)
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
        	return result;
        }
        result = searchRangeHelper(root, k1, k2, result);
        return result;
    }

    public ArrayList<Integer> searchRangeHelper(TreeNode root, int k1, int k2, ArrayList<Integer> result){
    	if(root == null){
    		return result;
    	}
    	if(k2 < root.val){
    		result = searchRangeHelper(root.left, k1, k2, result);
    	}else if(k1 > root.val){
    		result = searchRangeHelper(root.right, k1, k2, result);
    	}else{
    		result = searchRangeHelper(root.left, k1, k2, result);
    		result.add(root.val);
    		result = searchRangeHelper(root.right, k1, k2, result);
    	}
    	return result;
    }
}
