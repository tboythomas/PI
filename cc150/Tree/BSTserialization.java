public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        return buildhelper(root, res);
    }
    
    private String buildhelper(TreeNode root, String res){
        if(root == null){
            return res + "X" + ",";
        }
        res += root.val + ",";
        res = buildhelper(root.left, res);
        res = buildhelper(root.right, res);
        return res;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<String>();
        q.addAll(Arrays.asList(data.split(",")));
        return treehelper(q);
    }
    
    private TreeNode treehelper(Queue<String> q){
        String cur = q.remove();
        if(cur.equals("X")) return null;
        
            TreeNode root = new TreeNode(Integer.parseInt(cur));
            root.left = treehelper(q);
            root.right = treehelper(q);
            return root;
        
    }
}