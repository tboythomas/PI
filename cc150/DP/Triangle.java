public class Triangle {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    // note: for number[i][j], adajcent numbers in next row means number[i+1][j] and number[i+1][j+1]
    // use dp, search from the bottom to top.
    // for number[i][j], the shortest path from the next row to it is Math.min(number[i+1][j],number[i+1][j+1])+
    // number[i][j]
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	if(triangle == null || triangle.isEmpty()){
    		return 0;
    	}
    	int n = triangle.size();
    	int[][] counter = new int[n][n];
    	//assign the last row
    	ArrayList<Integer> last_row = triangle.get(n - 1);
    	for(int i = 0; i < n; i++){
    		counter[n-1][i] = last_row.get(i);
    	}
    	//start to search from the second last row
    	for(int j = n - 2; j >= 0; j--){
    		//since its a triangle, nth row has n elements
    		for(int k = 0; k <= j; k++){
    			counter[j][k] = Math.min(counter[i + 1][j], counter[i + 1][j + 1]) + triangle.get(j).get(k);    		}
    	}
    	return counter[0][0];
    }
}
