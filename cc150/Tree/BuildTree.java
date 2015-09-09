public class BuildTree {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */

    /*
    note: solution :http://blog.csdn.net/sbitswc/article/details/26433051
          from the preorder, we can get the root, from the inorder array, we can
          determine whether the node is on the left or right
    prcedure: preorder {7,10,4,3,1,2,8,11}
              inorder  {4,10,3,1,7,11,8,2}
              the root is 7
              7 is in inorder index 4.
              preorder {7} {10,4,3,1} {2,8,11}
              inorder  {4,10,3,1} {7} {11,8,2}
              keep recursing. 
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
    		return null;
    	}
        // build up a hash map to store each root and its index(val -- index)
        // if not hashmap, iterate through inorder array to find index for root in helper method
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i ++){
            counter.put(inorder[i], i);
        }
        return buildTreeHelper(counter, preorder, inorder, 0, preorder.length -1, 0, inorder.length -1);

    }

    public TreeNode buildTreeHelper(HashMap counter, int[] preorder, int[] inorder, int preL, int preR, int inL, int inR){
    	if(preL > preR){
    		return null;
    	}
        TreeNode root = new TreeNode(preorder[preL]);
        // root index
        int index = (int) counter.get(preorder[preL]);
        int len_left_tree = index - inL;
        root.left = buildTreeHelper(counter, preorder, inorder, preL + 1, preL + len_left_tree, inL, index - 1);
        root.right = buildTreeHelper(counter, preorder, inorder, preL + len_left_tree + 1, preR, index + 1, inR);
        return root;
    }
}