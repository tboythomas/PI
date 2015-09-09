class SubSet{
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    
    // note:
    // collections sort ArrayList. 
    // This problem includes two recursion methods. the first recursion is to find 
    // the solution at different length(start from 1 ends at num.size() since there is a
    // empty set at beginning)
    // the second recursion is to find the solution at fixed length with different element.
    // (change the parameter start (use recursive back tracking))
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> current = new ArrayList<Integer>();
    	// add empty set
    	result.add(current);
    	if(num == null){
    		return result;
    	}
    	Collections.sort(num);
    	// search from every index(this loop controls the length of each set)
    	for(int i = 1; i <= num.size(); i++){
    		current.clear();
    		helper(current, num, result, i, 0);
    	}
    	return result;
    }

    // a list have n elements, the total sub set number is n! + 2(one is a empty set and another one is itself)
    private void helper(ArrayList<Integer> current, ArrayList<Integer> num, ArrayList<ArrayList<Integer>> result,
    	int len, int start){
    	if(current.size() == len){
    		result.add(new ArrayList<Integer>(current));
    		return;
    	}
    	// this loop control individul element in each set
    	for(int i = start; i < num.size(); i ++){
    		current.add(num.get(i));
    		helper(current, num, result, len, i + 1);
    		current.remove(current.size() - 1);
    	}
    }
}