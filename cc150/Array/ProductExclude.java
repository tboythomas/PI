public class ProductExclude {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */

    // divied the array into two parts, part[0] is the subarray before i, 
    // part[1] is the subarray after i
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
   		if(A == null || A.size() == 0){
   			return A;
   		}
   		long[] left = new long[A.size()];
   		long[] right = new long[A.size()];
   		//set 1
   		left[0] = 1;
      //get the product of all left
   		for(int i = 1; i < A.size(); i++){
   			left[i] = left[i-1] * A.get(i-1);
   		}
   		right[A.size() - 1] = 1;
      //get product of all right
   		for(int j = A.size() - 2; j >= 0; j--){
   			right[j] = right[j+1] * A.get(j+1);
   		}
      ArrayList<Integer> result = new ArrayList<Integer>();
      for(int k = 0; k <A.size(); k++){
        result.add(left[k] * right[k]);
      }
      return result;
    }
}

