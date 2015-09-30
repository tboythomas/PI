/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // recursion (bad one)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
        	return true;
        }else if(p == null && q != null){
        	return false;
        }else if(p != null && q == null){
        	return false;
        }else if (p.val != q.val){
        	return false;
        }
        // if p.val == q.val, go to next level
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //-------------------------------------------------------------------
    // Iterate
    public boolean isSameTree(TreeNode p, TreeNode q){

    	Queue<TreeNode> counter1 = new LinkedList<TreeNode>();
    	Queue<TreeNode> counter2 = new LinkedList<TreeNode>();
    	counter1.offer(p);
    	counter2.offer(q);
    	while(!counter1.isEmpty() && !counter2.isEmpty()){
    		// pop the root out
    		TreeNode root1 = counter1.poll();
    		TreeNode root2 = counter2.poll();
    		// if root1 is null
    		if(root1 == null){
    			if(root2 != null){
    				return false;
    			}else{
    				continue;
    			}
    		}
    		// else if root1 is not null
    		else{
    			if(root2 == null || root2.val != root1.val){
    				return false;
    			}
    		}
    		counter1.offer(root1.left);
    		counter1.offer(root1.right);
   			counter2.offer(root2.left);
   			counter2.offer(root2.right);
    	}
    	return true;
    }
}