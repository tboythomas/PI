public class LCS {
    /**
     * @param nums: A list of integers
     * @return an integer
     */

    // note: since the required time is O(N), no sorting can be performed.
    // use a hash set to store every number, and then for every number, count its left 
    // and right, then remove the counted number(skip repeated counting), find the max
    // count and return.
    public int longestConsecutive(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return -1;
    	}
    	Set<Integer> counter = new HashSet<Integer>();
    	for(int i: nums){
    		counter.add(i);
    	}
    	// final result
    	int max = -1;
    	// count for the length of consecutive number
    	for(int i = 0; i < nums.length; i++){
    		if(counter.contains(nums[i])){
    			int left = nums[i] - 1;
    			int right = nums[i] + 1;
    			int count = 1;
    			while(counter.contains(left)){
    				count++;
    				counter.remove(left);
    				left--;
    			}
    			while(counter.contains(right)){
    				count++;
    				counter.remove(right);
    				right++;
    			}
    		 max = Math.max(max, count);

    		}
    	}
    	return max;
    }
}
