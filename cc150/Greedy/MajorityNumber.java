public class MajorityNumber {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */

    // greedy: solution for a small part of the problem can be the solution 
    // for the whole problem.
    // note: use a counter to keep counting. one pointer to keep the majority number.
    // if counter == 0 at index i, that means from nums[0] to nums[i], half of the number
    // is the majority number, we can restart from there and that wont affect our solution to
    // the whole problem
    public int majorityNumber(ArrayList<Integer> nums) {
    	if(nums == null || nums.size() == 0){
    		return -1;
    	}
        // start from nums[0] and it has appeared once
    	int counter = 1;
    	int majority = nums.get(0);
        for(int i = 1; i < nums.size(); i ++){
            if(nums.get(i) != majority){
                counter--;
            }else{
                counter++;
            }
            if(counter == 0){
                majority = nums.get(i);
                counter = 1;
            }
        }
        return majority;
    }
}