public class SearchForRange{
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */

    // note: binary search derivated version. Search for target by binary search, if target found,
    // use while loop to search indices of its duplicates(watch out the boundary for the while loop)
    // then return the two indices.
    // if no target founded, return (-1,-1)
    public ArrayList<Integer> searchRange(ArrayList<Integer> nums, int target) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(nums == null){
    		result.add(-1);
    		result.add(-1);
    		return result;
    	}
    	int low = 0;
    	int high = nums.size() -1;
    	while(low <= high){
    		int mid = (low + high) /2;
    		if(nums.get(mid) == target){
    			int left = mid;
    			int right = mid;
    			while(left > 0 && nums.get(left -1) == target){
    				left--;
    			}
    			while(right < nums.size() - 1 && nums.get(right + 1) == target){
    				right++;
    			}
    			result.add(left);
    			result.add(right);
    			return result;
    		}
    		else if(nums.get(mid) < target){
    			low = mid + 1;
    		}else{
    			high = mid - 1;
    		}
    	}
    	result.add(-1);
    	result.add(-1);
   		return result;
    }
}