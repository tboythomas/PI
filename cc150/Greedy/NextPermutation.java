/*
Given a list of integers, which denote a permutation.

Find the next permutation in ascending order.
*/

// explanation: http://blog.csdn.net/qq575787460/article/details/41206601
// note: understand what permutation is.
// permutation, ex: 
// 1. from back, find the first pair in nums such that nums[i] > nums[i -1], mark these two as i and ii
// 2. from back, find the first element in nums such that nums[j]> nums[i], and then swap them
// 3. reverse all elements since nums[ii](including itself)
// 4. if the nums is strictly ascending, reverse it all
// ex :
//  8342666411
//  1. i is 6, ii is 2
//  2. j is 4, after swap, 8344666211
//  3. after reverse, 8344112666
public class NextPermutation {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
     
    public int[] reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }
    public int[] nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return nums;
        }
        int pos = -1;
        // find the first ascending pair(i and ii)
        for(int i = nums.length - 1; i > 0; i --){
            if(nums[i] > nums[i - 1]){
                pos = i - 1;
                break;
            }
        }
        // strictly ascending array, reverse all
        if(pos == -1){
            nums = reverse(nums, 0, nums.length - 1);
            return nums;
        }
        int counter = -1;
        // find j
        for(int i = nums.length -1; i > pos; i--){
            if(nums[i] > nums[pos]){
                counter = i;
                break;
            }
        }
        int temp = nums[pos];
        nums[pos] = nums[counter];
        nums[counter] = temp;
        nums = reverse(nums, pos + 1, nums.length -1);
        return nums;
    }
}
