class PeakElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */

    // note: binary search. compare nums[mid] to nums[mid + 1], if nums[mid+1] > nums[mid],
    // mid might be a peak(keep searching on the left side). Otherwise search on the right side.
    public int findPeak(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int low = 0;
        int high = nums.length -1;
        while(low <= high){
            int mid = (low + high) /2;
            if(nums[mid] > nums[mid + 1]){
                // itself might be a peak
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
