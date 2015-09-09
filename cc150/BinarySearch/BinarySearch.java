class BinarySearch {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */

    // note:
    // perform a normal binary search. When find the target number, scan backfoward while mid > 0 && it has duplicates,
    // and return the index when the first target occurs.
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
        	int mid = (low + high) /2;
        	if(nums[mid] == target){
        	    while(mid > 0 && nums[mid - 1] == nums[mid]){
        	        mid --;
        	    }
        	    return mid;
        	}else if (nums[mid] > target){
        		high = mid - 1;
        	}else{
        		low = mid + 1;
        	}
        }
        return -1;
    }
}
