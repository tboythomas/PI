public class UniquePath{
    /*
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    
    // note: solving this problem in dp. two-d array. 
    // the number of unique path to one cell [i][j] = number of cell[i-1][j] + number of cell[i][j-1]
    // m is the row number, n is the col!
    public int uniquePaths(int m, int n) {
    	if(m ==0 && n ==0){
    		return 0;
    	}
    	int[][] counter = new int[m][n];
    	for(int i = 0; i < n; i++){
    		counter[0][i] = 1;  
    	}
    	for(int j =0; j < m; j++){
    		counter[j][0] = 1;
    	}

    	for(int k = 1; k < n; k++){
    		for(int h = 1; h < m; h++){
    			counter[h][k] = counter[h-1][k] + counter[h][k-1];
    		}
    	}
    	return counter[m -1][n -1];
    }
}
