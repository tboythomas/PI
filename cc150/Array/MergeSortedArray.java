class MergeSortedArray{
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */

    //note: compare the vaule from back of the array, put the vaule from back to front, and then
    // check if index in A or B is still greater than 0, if it is, put the rest into array.
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
    	int i = m - 1 , j = n -1, index = m + n -1;
    	while(i >= 0 && j >= 0){
    		if(A[i] > B[j]){
    			A[index--] = A[i--];
    		}else{
    			A[index--] = B[j--];
    		}
    	}
    	while(i >= 0){
    		A[index--] = A[i--];
    	}
    	while(j >= 0){
    		A[index--] = B[j--];
    	}	
    }
}

