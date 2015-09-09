public class ProductExculde {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
        	return nums;
        }
        int len = nums.length;
        int[] ans = new int[len];
        //calculate the product of left elements before nums[i]
        // start with 1(no actual meaning, there is no product before the first element)
        ans[0] = 1;
        for(int i = 1; i < len; i ++){
        	ans[i] = ans[i - 1] * nums[i - 1];
        }
        int right = 1;
        // calculate the product of right elements
        for(int j = len -1; j >= 0; j --){
        	ans[j] = right * ans[j];
        	right = right * nums[j];
        }
        return ans;
    }
}