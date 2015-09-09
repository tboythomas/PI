public class CombineSum {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */

    // note:
    // first sort the candidates(later on when we check the value, if the value is greater than target
    // we can break the loop immediately)
    // perform a recursive backtracking with start index, for this problem, remember to mark down the previous 
    // solution (otherwise it will keep adding itself, produce repeated solutions)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(candidates == null || candidates.length == 0){
    		return result;
    	}
    	List<Integer> current_list = new ArrayList<Integer>();
    	Arrays.sort(candidates);
    	helper(candidates, target, result, current_list, 0);
    	return result;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> current_list, int index){
		if(target == 0){
			result.add(new ArrayList(current_list));
			return;
		}
		// mark the previous solution
		int pre = -1;
    	for(int i = index; i < candidates.length; i++){
    		if(candidates[i] > target){
    			break;
    		}
    		// skip the repeated solution
    		if(pre != -1 && pre = candidates[i]){
    			continue;
    		}else{
    		//choose
    		current_list.add(candidates[i]);
    		// check and update the index
    		helper(candidates, target - candidates[i], result, current_list, i);
    		// remove
    		current_list.remove(current_list.size() - 1);
    		}
    	}
    }
}
