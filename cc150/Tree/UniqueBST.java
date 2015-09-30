public class UniqueBST {
	// this is https://en.wikipedia.org/wiki/Catalan_number
    public int numTrees(int n) {
        if(n == 0){
        	return 0;
        }
        int[] counter = new int[n + 1];
        counter[0] = 1;
        // outer loop iterate for each node
        for(int i = 1; i < n + 1; i ++){
        	// inner loop separate for left tree and right tree
        	for(int j = 0; j < i; j ++){
        		counter[i] += counter[j] * counter[i - j - 1];
        	}
        }
        return counter[n];
    }
}