class UpdateBits {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */

    // note: first set all the bit in n between i and j to 0
    // and then set them to number m
    public int updateBits(int n, int m, int i, int j) {
    	// 1111 1111 , i =2, j =4
    	int max = ~0;
    	// right = x
    	int right = max - ((1 << j+1) - 1);
    	int left = (1 << i) - 1;
    	int mask = right | left; 
    	int result = (mask & n) | (m << i);
    	return result;
    }
}

