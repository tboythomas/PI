public class UniqueBST {
    /**
     * @paramn n: An integer
     * @return: An integer
     */

   	// note: dynamic programing. For any root i in a BST, the left child is [0, i-1]
   	// right child is [i+1, n]. the number of unique bst in left child is count[i-1]
   	// the number of unique best in right child is count[n -i -1]
   	// counter[i] += count[n-i] * count[n-i-1]

    public int numTrees(int n) {
    	if(n == 0 || n == 1){
    		return 1;
    	}
    	int[] count = new int[n + 1];
    	count[0] = 1;
    	for(int i = 1; i < n + 1 ; i++){
    		for(int j = 0; j < i; j++){
    			count[i] += count[j] * count[i - j - 1];
    		}
    	}
    	return count[n];
    }
}

