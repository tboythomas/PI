public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        // map the root val to its index, O(n) time when check the index for root
        for(int i = 0; i < inorder.length; i ++){
            m.put(inorder[i], i);
        }
        return helper(preorder, inorder, m, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode helper (int[] preorder, int[] inorder, HashMap<Integer, Integer> m, int preL, int preR, int inL, int inR){
        if(preL > preR || inL > inR){
            return null;
        }
        int val = preorder[preL];
        int ind = m.get(val);
        TreeNode root = new TreeNode(val);
        int left_tree = ind - inL;
        root.left = helper(preorder, inorder, m, preL + 1, preL + left_tree, inL, ind - 1);
        root.right = helper(preorder, inorder, m, preL + left_tree + 1, preR, ind + 1, inR);
        return root;
    } 
}