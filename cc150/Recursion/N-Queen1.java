// N-Quuen output the solution numbers
public class N-QueenI {
	private int ans = 0;
    public int totalNQueens(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        search(result, n);
        return ans;
    }

    private void search(ArrayList<Integer> result, int n){
    	if(result.size() == n){
    		ans++;
    		return;
    	}else{
    		// iterate each col at given row
    		for(int i = 0; i < n; i++){
    			// try every col on next row
    			if(!isValid(result, i)){
    				continue;
    			}else{
    				// add this col, and then search every row on this col
    				result.add(i);
    				search(result, n);
    				result.remove(result.size() - 1);
    			}
    		}
    	}
    }

    private boolean isValid(ArrayList<Integer> result, int col){
    	int row = result.size();
    	for(int i = 0; i < row; i++){
    		// result.get(i) is the row
    		if(result.get(i) == col){
    			return false;
    		}
    		// top-left to bottom right
    		else if (i - result.get(i) == row - col){
    			return false;
    		}
    		// bottom-right to top left
    		else if (i + result.get(i) == row + col){
    			return false;
    		}
    	}
    	return true;
    }
}
//-------------N Queen II : output the board (instead of increment the ans, add current list to solution list)
// one more method to print the board

private String[] print_board(List<Integer> queen){
	String[] ans = new String[queen.size()];
	for(int i = 0; i < queen.size(); i ++){
		ans[i] = "";
		for(int j = 0; j < queen.size(); j++){
			if(queen.get(j) == i){
				ans[i] += "Q";
			}else{
				ans[i] += ".";
			}
		}
	}
	return ans;
}