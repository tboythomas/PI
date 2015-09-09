public class PartitionArray {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */

   // note: since all element < k must be on the left, this array does not have to be strictly sorted.
   // so we just use two pointer, keep iterating from left and right, if num[left] < target and num[right] >= target
   // we do have to swap if num[left] > target or num[right] < target.
   // think about quicksort.
   public  int partitionArray(int[] nums, int k) {
      if(nums == null){
         return 0;
      }
      int target = k;
      int left = 0;
      int right = nums.length - 1;
      while(left <= right){
         while(left <= right && nums[left] < target){
            left++;
         }
         while(left <= right && nums[right] >= target){
            right--;
         }
         if(left <= right){
            swap(nums, left, right);
            left++;
            right--;
         }
      }
      return left;
   }
    
   public  void swap(int[] arr, int left, int right){
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
   }
}