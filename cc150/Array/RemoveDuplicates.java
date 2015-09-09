
public class RemoveDuplicates {
    /**
     * @param nums: a array of integers(sorted)
     * @return : return an integer
     */

    // note: use one iterator varible, loop through the array, compare the iterator and nums[i], if nums[i]
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int size = 0;
        for(int i = 1; i < nums.length; i ++){
            if(nums[size] != nums[i]){
                size++;
                nums[size] = nums[i];
            }
        }
        return size + 1;
    }
    
    public static void main(String[] args){
    	int[] nums = {-14,-14,-13,-13,-13,-13,-13,-13,-13,-12,-12,-12,-12,-11,-10,-9,-9,-9,-8,-7,-5,-5,-5,-5,-4,-3,-3,-2,-2,-2,-2,-1,-1,-1,-1,-1,0,1,1,1,1,2,2,2,3,3,3,4,4,4,4,5,5,5,6,6,6,6,7,8,8,8,9,9,9,10,10,10,11,11,11,12,12,12,13,14,14,14,14,15,16,16,16,18,18,18,19,19,19,19,20,20,20,21,21,21,21,21,21,22,22,22,22,22,23,23,24,25,25};
    	System.out.print(removeDuplicates(nums));
    }
}