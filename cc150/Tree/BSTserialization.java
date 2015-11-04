class BSTserialization {


// note: 
//   serialize: generate a string in preorder, (null node will be makred as -1), 
//   use "." to separate each node.val
//   deserialize: use a counter to keep track of the process, genreate the tree in preorder.
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public int counter = 0;
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        String result = "";
        result = maketree(root, result);
        return result;
    }
    
    public String maketree(TreeNode root, String result){
        if(root == null){
           return result+ "-1"+".";
        }
        result += root.val +".";
        result = maketree(root.left, result);
        result = maketree(root.right,result);
        return result;
    }
    
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }
        // splite the string by separator(".")
        String[] preorder = data.split("\\.");
        //generate null node
        if(preorder[counter].equals("-1")){
            counter++;
            return null;
        }

        int val = Integer.parseInt(preorder[counter]);
        TreeNode node = new TreeNode(val);
        counter++;
        node.left = deserialize(data);
        node.right = deserialize(data);
        return node;
    }
}
