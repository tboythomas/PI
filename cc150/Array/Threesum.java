public class 3Sum {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    
    // note: (2 sum) sort the array first!!!
    // this problem can be solved in the way that 2sum being sovled. Using two pointers, num[0] and num[len -1]
    // while left < right, if the sum is larger than target, right --, else left++, if the sum is the target, return 
    // the list contains those two numbers.

    // For this problem, using a loop to take one number at each time, then transfer this to 2 sum problem. (watch out the limit
    // for each loop and the duplicated values)
    public List<List<Integer>> threeSum(int[] numbers) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numbers == null || numbers.length < 2){
        	return result;
        }
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length; i ++){
            //skip the duplicates
        	if( i != 0 && numbers[i] == numbers[i - 1]){
        		continue;
        	}
    		int left = i + 1;
    		int right = numbers.length -1;
    		while(left < right){
    			int sum = numbers[i] + numbers[left] + numbers[right];
    			if(sum == 0){
    				List<Integer> temp = new ArrayList<Integer>();
    				temp.add(numbers[i]);
    				temp.add(numbers[left]);
    				temp.add(numbers[right]);
    				result.add(new ArrayList(temp));
    				left++;
    				right--;
    				//skip the duplicates,(left and left -1)
    				while(left < right && numbers[left] == numbers[left - 1]){
    					left++;
    				}
    				//skip the duplicates(right and right + 1)
    				while(left < right && numbers[right] == numbers[right + 1]){
    					right--;
    				}
    			}else if(sum > 0){
    				right--;
    			}else{
    				left++;
    			}
    		}
        }
		return result;
    }
}
