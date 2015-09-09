public class UniquePathII{
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] board) {
        if(board == null || board[0].length == 0 || board.length == 0){
            return 0;
        }
        int n = board[0].length;
        int m = board.length;
        // row first, col second
        int[][] counter = new int[m][n];
        counter = mark(counter);
        // check the first row, if there is obstacle, break the loop, else there is a path(set to 1)
        for(int i = 0; i < n; i++){
            if(board[0][i] == 1){
                break;
            }else{
                counter[0][i] = 1;
            }
        }
        // check the first col
        for(int j = 0; j < m; j++){
            if(board[j][0] == 1){
                break;
            }else{
                counter[j][0] = 1;
            }
        }
        // check for obstacle, if there is one, set to 0, otherwise calculate the path
        for(int k = 1; k < m; k++){
            for(int h = 1 ; h < n; h++){
                if(board[k][h] != 1){
                    counter[k][h] = counter[k-1][h] + counter[k][h-1];
                }else{
                    counter[k][h] = 0;
                }
            }
        }
        return counter[m-1][n-1];
    }

    private int[][] mark(int[][] counter){
        for(int i = 0; i < counter[0].length; i ++){
            counter[0][i] = 0;
        }
        for(int j = 0; j < counter.length; j++){
            counter[j][0] = 0;
        }
        return counter;
    }
}
