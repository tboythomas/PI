public class Backpack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */

    // note : backpack problem
    /* transformation equation
           for (int i = 0; i < N; ++i) {
            for (int j = 0; j <= M; ++j) {
                result[i + 1][j] = result[i][j];
                if (j >= A[i] && result[i - 1][j - A[i]]) {
                    result[i][j] = true;
                }
            }
         `}
      Detail info: http://www.code123.cc/docs/leetcode-notes/dynamic_programming/backpack.html
    */
    public int backPack(int m, int[] A) {
		if(A == null || A.length == 0 || m < 1){
			return 0;
		}
		//initial state ([item number][val])(0 item with any val is false || 0 val with any item is false)
		boolean[][] counter = new int[A.length + 1][ m + 1];
		for(int i = 0; i < A.length + 1; i++){
			for(int j = 0; j < m + 1; j++){
				counter[i][j] = false;
			}
		}
		// only when 0 item with 0 val, it is true
		counter[0][0] = true;
		for(int i = 0; i < A.length; i ++){
			for(int j = 0; j <= m; j++){
				//put one item in the bag (default is false)
				counter[i + 1][j] = counter[i][j];
				// if current item val < max and previous item val < (max - current val)
				// we can put the item into the bag
				if(j >= A[i] && counter[i][j - A[i]]){
					counter[i + 1][j] = true;
				}
			}
		}
		// search for the largest max val
		for(int i = m; i >= 0; i--){
			if(counter[A.length][m]){
				return i;
			}
		}
		return 0;
	}
}
