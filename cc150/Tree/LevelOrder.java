public class LevelOrder {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    
    // note: basic operation for stack(push, pop) and queue(offer, poll)
    // 		perform a BFS, use a queue to store node, but need a for loop to iterate nodes at each level
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(root == null){
    		return result;
    	}
    	Queue<TreeNode> counter = new LinkedList<TreeNode>();
    	counter.offer(root);
    	while(!counter.isEmpty()){
    		ArrayList<Integer> level = new ArrayList<Integer>();
    		int size = counter.size();
    		// pop the node at curret level, and add their childs
    		for(int i = 0; i < size; i ++){
    			TreeNode temp = counter.poll();
    			level.add(temp.val);
    			if(temp.left != null){
    				counter.offer(temp.left);
    			}
    			if(temp.right != null){
    				counter.offer(temp.right);
    			}
    		}
    		result.add(level);
    	}
    	return result;
    }
}