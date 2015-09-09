/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class TopologicalSort{
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    	if(graph == null){
    		return graph;
    	}
    	ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
    	HashMap<DirectedGraphNode, Integer> counter = new HashMap();
    	// count the egdes for each node
    	for(DirectedGraphNode node: graph){
    		for(DirectedGraphNode temp: node.neighbors){
    			if(counter.containsKey(temp)){
    				counter.put(temp, counter.get(temp) + 1);
    			}else{
    				counter.put(temp, 1);
    			}
    		}
    	}
    	// push the root(root is the node that doesnt have any node points to it)
    	Stack<DirectedGraphNode> s = new Stack<DirectedGraphNode>();
    	for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                s.push(node);
                result.add(node);
            }
        }
    	// start to traverse
    	while(!s.isEmpty()){
    		// pop the current node
    		DirectedGraphNode temp = s.pop();
    		// decrease the number of edges for each node
    		for(DirectedGraphNode neighbor: temp.neighbors){
    			counter.put(neighbor, counter.get(neighbor) - 1);
    			// if the # of edge is 0, put it into result,
    			// add it into stack and start to traverse from it again
    			if(counter.get(neighbor) == 0){
    				s.push(neighbor);
    				result.add(neighbor);
    			}
    		}
    	}
    	return result;
    }
}
