/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // preorder: root - left - right, 
 // inorder: left- root - right
 // postorder: left - right - root
public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if(root == null){
        	return result;
        }
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> result){
    	if(root == null){
    		return;
    	}    	
    	result.add(root.val);
    	traversal(root.left, result);
    	traversal(root.right, result);
    }
}