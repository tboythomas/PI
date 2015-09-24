public class Solution {
    // O(N^2) Complexity
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
        	return;
        }
        int right = nums.length - 1;
        for(int i = 0; i < right; i ++){
        	if(nums[i] == 0){
        		for(int j = i; j <= right; j ++){
        		    if(nums[j] != 0){
        		        int temp = nums[j];
        		        nums[j] = nums[i];
        		        nums[i] = temp;
        		        break;
        		    }
        		}
        	}
        }
    }

    // Using O(N) Complexity, use a counter to count the zeor in the array and then assign them
    public void moveZeroes(int[] nums){
    	if(nums.length == 0){
    		return;
    	}
    	int pos = 0;
    	for(int temp: nums){
    		if(temp != 0){
    			nums[pos] = temp;
    			pos++;
    		}
    	}
    	while(pos < nums.length){
    		nums[pos] = 0;
    		pos++;
    	}
    }

}