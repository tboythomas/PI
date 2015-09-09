public class FirstPositive {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    //note: put every positive integer i on index[i-1], then scan the array, find the first missing positive.
      public int firstMissingPositive(int[] A) {
        if(A == null || A.length == 0){
            return 1;
        }
        int len = A.length;
        for(int i =0; i< len; i++){
         int temp = 0;
            //watch out the order
            while(A[i] != i + 1 && A[i] > 0 && A[i] <len + 1&& A[i] != A[A[i] - 1]){
                temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }

        for(int j =0; j < len; j++){
            if(A[j] != j + 1){
                return j + 1;
            }
        }
        //no missing positive i in between
        return len + 1;
    }

    public void swap(int a, int b){
        int temp = b;
        b = a;
        a = temp;
    }
}

    
    public static void main(String[] args){
    	int [] A={2,1};
    	System.out.print(firstMissingPositive(A));
    }
}