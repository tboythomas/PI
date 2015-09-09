public class MaxProduct{
    /**
     * @param nums: an array of integers
     * @return: an integer
     */

    // note: for product, keep the min and max at the same time(in case there is a negative number 
    // at the end, so the min will become the max).
    // calculate the local max and local min every time, and then update them. if the global max or min is 
    // less the current position number or greater than the current position number, reset it to current position
    // and then update the result(the result is initially set to nums[0], in case nums[0] is the largest element)
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int max = nums[0];
        int min = nums[0];
        int product = nums[0];
        for(int i = 1; i < len; i ++){
        	int temp_max = max * nums[i];
        	int temp_min = min * nums[i];
        	max = Math.max(Math.max(temp_min, temp_max), nums[i]);
        	min = Math.min(Math.min(temp_max, temp_min), nums[i]);
        	product = Math.max(max, product);
        }
        return product;
    }
}