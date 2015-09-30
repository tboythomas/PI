// single number series solution :
// https://leetcode.com/discuss/31595/detailed-explanation-generalization-bitwise-operation-numbers
// https://leetcode.com/discuss/52351/accepted-java-space-easy-solution-with-detail-explanations
public class SingleNumber {
    // k = 2; p = 1
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
        	return -1;
        }
        int x1 = 0;
        for(int i = 0; i < nums.length; i ++){
        	x1 ^= nums[i];
        }
        return x1;
    }

    // single number II
    public int singleNumber (int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int x2 = 0;
        int x1 = 0;
        int mask = 0;
        for(int i = 0; i < nums.length; i ++){
            // xm ^= ~(xm-1 & xm-2 ....& x1 & nums[i])
            x2 ^= x1 & nums[i];
            x1 ^= nums[i];
            // k = 3, in binary 11, mask = ~(x2 & x1)
            mask = ~(x2 & x1);
            x2 &= mask;
            x1 &= mask;
        }
        return x1;
    }

    // single number III
    public int[] singleNumber(int[] nums) {    
        if(nums == null || nums.length == 0){
            return -1;
        }
        //first pass get AxorB
        int AxorB = 0;
        for(int temp: nums){
            AxorB ^= temp;
        }
        // get the last set bit
        AxorB &= -AxorB;

        //second pass to sperate the numbers and get the result
        int[] ans = {0,0};
        for(int temp: nums){
            if( (AxorB & temp) == 0){
                ans[0] ^= temp;
            }else{
                ans[1] ^= temp;
            }
        }
        return ans;
    }
}