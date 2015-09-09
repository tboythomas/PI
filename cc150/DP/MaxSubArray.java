public class MaxSubArray {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */

    // note:  Kadane's algorithm (http://en.wikipedia.org/wiki/Maximum_subarray_problem)
    // use a point sum, if sum >= 0, connect it with the next number, cuz no matter what, a number
    // plus a positive number is always bigger. otherwise if sum < 0, restart to count the sub array from
    // that position since a number plus a negative number is always smaller.
    public int maxSubArray(ArrayList<Integer> nums) {
    	if(nums == null || nums.isEmpty()){
    		return 0;
    	}
    	int len = nums.size();
    	// dummy val to get replaced
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.size(); i ++){
            if(sum >= 0){
                sum += nums.get(i);
            }
            // reset the subarray
            else{
                sum = nums.get(i);
            }
            // set the max
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}
