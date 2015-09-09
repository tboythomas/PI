public class InsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
        	// there is no difference between (left + right) / 2 and (left + (right - left)/2) mathmetically
        	// but (left + right) / 2 will cuz a overflow sometimes.
        	int mid = left + (right - left) / 2;
        	if(nums[mid] < target){
        		left = mid + 1;
        	}else if(nums[mid] > target){
        		right = mid - 1;
        	}else{
        		return mid;
        	}
        }
        return left;
    }
}