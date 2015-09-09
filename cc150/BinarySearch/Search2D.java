public class Search2D{
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
    **/
    /*
   	[
	    [1, 3, 5, 7],
	    [10, 11, 16, 20],
	    [23, 30, 34, 50]
	]
	 */

    // solution 1 : O(mn) 
    // use two pointer, one at beginning, one at end. Use the first one to locate the row index
    // if matrix[row][col] < target, go to next row.
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        if(len == 0){
            return false;
        }
        int wid = matrix[0].length;
        if(wid == 0){
            return false;
        }
        int low = 0;
        int high = wid - 1;
        while(low < len && high >= 0){
            if(matrix[low][high] == target){
                return true;
            }else if (matrix[low][high] > target){
                high --;
            }else{
                low ++;
            }
        }
        return false;
    }

    // solution 2
    // use binary search to locate the row index, then use a binary search to find the col index.
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0){
            return false;
        }
        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int bot = 0;
        int top = matrix.length - 1;
        while(bot <= top){
            int mid = (bot + top) /2;
            if(matrix[mid][0] == target){
                return true;
            }else if (matrix[mid][0] > target){
                top = mid - 1;
            }else{
                // locate the row. if the target > matrix[row][0] && < matrix[row+1][0],
                // set the row value
                if(bot == matrix.length - 1 || matrix[mid + 1][0] > target)
                    break;
                bot= mid + 1;
            }
        }
        int row = bot;
        int low = 0;
        int high = matrix[row].length - 1;
        while(low <= high){
            int mid = (low + high) /2;
            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}