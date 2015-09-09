public class Combination{
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */

    // note: 
    // for recursive backtracking, 3 steps, choose, record, unchoose
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> current_list = new ArrayList<Integer>();
		combinehelper(result, current_list, n, k , 1);
		return result;
    }

    private void combinehelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current_list, 
    	int n, int k, int start){
    	// return the list if the condition is met
    	if(current_list.size() == k){
    		// why add	(new ArrayList(current_list)) instead of adding (current_list)?
    		// current_list is always changing, (for example, when first it is (1,2),
    		// but then we remove 2 and add 3, it became (1,3), the current_list we added previously 
    		// changed to (1,3) as well. thats why we need to construct a new ArrayList to store current_list every time.
    		result.add(new ArrayList(current_list));
    		return;
    	}
    	for(int i = start; i <= n;i++){
    		// choose
    		current_list.add(i);
    		// mark
    		combinehelper(result, current_list, n, k, i+1);
    		// unchoose
    		current_list.remove(current_list.size() - 1);
    	}
    }

}