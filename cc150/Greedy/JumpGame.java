/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.
*/

public class JumpGame {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */

    //note: get the max step every time. if reach the end, return true, otherwise, return false.
    public boolean canJump(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return false;
    	}
    	int step = nums[0];
    	for(int i = 1; i < nums.length; i ++){
    		if(step > 0){
    			step --;
    			step = Math.max(step, nums[i])
    		}else{
    			return false;
    		}
    	}
    	return true;
    }
}

