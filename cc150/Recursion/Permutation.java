class Permutation {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0){
        	return result;
        }
        int size = nums.size();
        int len = len(size);
        // total numbers of permutation
        ArrayList<Integer> temp = new ArrayList<Integer>(nums);
        for(int i = 0; i < len; i++){
        	result.add(new ArrayList<Integer>(temp));
        	temp = nextPermutation(temp);
        }
        return result;
    }

    private ArrayList<Integer> nextPermutation(ArrayList<Integer> nums){
    	int len = nums.size();
    	int[] current = new int[len];
    	Arrays.sort(current);
    	for(int i = 0; i < len; i ++){
    		current[i] = nums.get(i);
    	}
    	int pos = -1;
    	//find the first pair from back
    	for(int j = len -1; j > 0; j--){
    		if(current[j] > current[j -1]){
    			pos = j -1;
    			break;
    		}
    	}
    	// strictly ascending
    	if(pos == -1){
    		return reverse(current, 0, len -1);
    	}
    	int counter = -1;
    	for(int k = len - 1; k >0; k --){
    		if(current[k] > current[pos]){
    			counter = k;
    			break;
    		}
    	}
    	//from back, swap the first element is greater than current[pos]
    	int temp = current[pos];
    	current[pos] = current[counter];
    	current[counter] = temp;
    	// reverse
    	return reverse(current, pos + 1, len -1);
    }

    private ArrayList<Integer> reverse(int[] current, int left, int right){
    	while(left < right){
    		int temp = current[left];
    		current[left] = current[right];
    		current[right] = temp;
    		left++;
    		right--;
    	}
    	ArrayList<Integer> temp = new ArrayList<Integer>();
    	for(int i = 0; i < current.length; i++){
    		temp.add(current[i]);
    	}
    	return temp;
    }
    // return the factorial of n
    private	int len(int n){
    	int result = 1; 
    	for(int i = 1; i <= n ; i ++){
    		result = result * i;
    	}
    	return result;
    }
}