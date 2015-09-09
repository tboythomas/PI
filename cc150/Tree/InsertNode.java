public class InsertNode {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */

    // note: if node > cuurent.root, modify root.right, else insert it on root.left
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if(root == null){
        	return node;
        }
        if(node.val > root.val){
        	root.right = insertNode(root.right, node);
        }else{
        	root.left = insertNode(root.left, node);
        }
        return root;
    }
}