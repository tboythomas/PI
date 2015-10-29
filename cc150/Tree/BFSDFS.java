// Run time complexity for both is O(n) since we need to check every node
// Space complexity - depends on the implementation, a recursive implementation can have a O(h) 
// space complexity [worst case], where h is the maximal depth of your tree. 
// Using an iterative solution with a stack is actually the same as BFS, just using a stack
// instead of a queue - so you get both O(|V|) time and space complexity.
// DFS pre order traversal
// DFS is used when we want to check every node in the tree, or at least visit every
// node until we find the target
public void DFS(TreeNode root){
    if(root == null){
        return;
    }
    DFS(root.left);
    //System.out.print(root);
    //do something with the root
    DFS(root.right);
}


// When the tree gets too big, we might want to use BFS instead.
public void BFS(TreeNode root){
    if(root == null){
        return;
    }
    // mark the root
    Queue<TreeNode> q = new Queue<TreeNode>();
    q.offer(root);
    while(!q.isEmpty()){
        TreeNode temp = q.poll();
        if(temp.left != null){
            q.offer(temp.left);
        }
        if(temp.right != null){
            q.offer(temp.right);
        }
    }
}

