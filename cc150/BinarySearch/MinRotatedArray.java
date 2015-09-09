public class MinRotatedArray {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */

    // note: binary search, compare the mid value with the last number in the array,
    // if num[mid] > num[num.length -1], min val will be on the right part of the array
    // ohterwise it will be on the left part.
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) /2;
            if(nums[mid] > nums[nums.length-1]){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return nums[low];
    }
}
