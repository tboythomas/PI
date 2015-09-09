public class sortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        TreeNode root = makeBST(nums, 0, nums.length - 1);
        return root;
    }
    
    // make bst
    private TreeNode makeBST(int[] nums, int left, int right){
        if (left > right){
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // watch out the parameter passed in
        root.left = makeBST(nums, left, mid - 1);
        root.right = makeBST(nums, mid + 1, right);
        return root;
    }
}