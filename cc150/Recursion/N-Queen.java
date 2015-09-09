class N-Queen {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */

    // note: return puzzle with n queens placed.(only can be done with n >= 4)
    // for each queen on the board, mark the range that it can reach, eliminate the position
    // that the next queen can be placed.
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    	if(n == null || n < 4){
    		return result;
    	}
    	// mark the position for queens
    	ArrayList<Integer> queen = new ArrayList<Integer>();
		search(n, queen, result);    	
    }

    private void search(int n, ArrayList<Integer> queen, ArrayList<ArrayList<String>> result){
    	if(result.size() == n){
    		result.add(print_result(queen));
    		return;
    	}else{
    		// check if current col is vaild, if it is, check the next col
    		// this loop is check for each col
    		for(int i = 0; i < n; i++){
    			// if not vaild, check the next col
    			if(!isVaild(i, queen)){
    				continue;
    			}
    			else{
    				queen.add(i);
    				search(n, i, result);
    				queen.remove(queen.size() -1);
    			}
    		}
    	}
    }

    private boolean isVaild(int col, ArrayList<Integer> queen){
    	//this loop is check for each row at that col
    	int row = queen.size();
    	for(int i = 0; i < row; i ++){
    		// same col
    		if(queen.get(i) == i){
    			return false;
    		}
    		// left-top and right-bottom
    		if(i - queen.get(i) == row - col){
    			return false;
    		}
    		//left-bottom and right-top
    		if(i + queen.get(i) == row - col){
    			return false;
    		}
    	}
    	return true;
    }

    private String[] print_result(ArrayList<Integer> queen){
    	String[] result = new String[queen.size()];
    	// traverse each col
        for(int i = 0; i < queen.size(); i++){
    		result[i] = "";
    		// ...Q. -> (queen.get(0) = 3), this loop is traversing the row
            // if there is a q.(j = col.get(i), print it out)
    		for(int j = 0; j < queen.size(); j++){
    			if(queen.get(j) == i){
    				result[i] += "Q";
    			}else{
    				result[i] += ".";
    			}
    		}
    	}
    	return result;
    }
};
