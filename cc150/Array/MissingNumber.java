public class MissingNumber {
   	// required to be linear complexity. Using bit Manipulation
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        // Xor the num from 0 to nums.length , then Xor num in the input array, 
        // since other number all appear twice, the only missing number only appeared once, 
        // and its the result
        int res = 0;
        for(int i = 0; i <= nums.length; i ++){
        	res ^= i;
        }
        for(int n: nums){
        	res ^= n;
        }
        return res;    
    }
}
