public class InsertPosition{
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */

    // note: perform a basic binary search
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
        	return 0;
        }
        int low = 0;
        int high = A.length - 1;
        while(low <= high){
        	int mid = (low + high) / 2;
        	if(A[mid] == target){
        		return mid;
        	}else if (A[mid] > target){
				high = mid - 1;
        	}else{
        		low = mid + 1;
        	}
        }
        return low;
    }
}