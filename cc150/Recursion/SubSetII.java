class SubSetII {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> current = new ArrayList<Integer>();
    	result.add(current);
    	if(num == null){
    		return result;
    	}
    	Collections.sort(num);
    	// length starts from 1 ( has empty set already)
    	for(int i = 1; i <= num.size(); i ++){
    		current.clear();
    		helper(result, current, num, i, 0);
    	}
    	return result;
    }

    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, ArrayList<Integer> num, 
    	int len, int start){
    	if(current.size() == len){
    		result.add(new ArrayList<Integer>(current));
    		return;
    	}
    	int i = start;
    	while(i < num.size()){
    		current.add(num.get(i));
    		helper(result, current, num, len, i + 1);
    		current.remove(current.size() - 1);
    		while(i < num.size() - 1 && num.get(i) == num.get(i+1)){
    	        i++;
    	    }
    	    i++;
    	}
    }
}

