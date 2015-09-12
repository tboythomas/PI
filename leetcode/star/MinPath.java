public class MinPath {
    public int minPathSum(int[][] nums) {
        if(nums == null || nums[0].length == 0){
            return 0;
        }
        int wid = nums[0].length;
        int len = nums.length;
        int[][] counter = new int[len][wid];
        // set the origin
        counter[0][0] = nums[0][0];
        // set up the first row and col first
        for(int i = 1; i < len; i++){
            counter[i][0] = counter[i - 1][0] + nums[i][0];
        }
        for(int j = 1; j < wid; j++){
            counter[0][j] = counter[0][j - 1] + nums[0][j];
        }
        for(int i = 1; i < len; i ++){
            for(int j = 1; j < wid; j ++){
                // to reach certian box, the cost = min of (cost to its adjacent box(above or left)) + its val
                counter[i][j] = Math.min(counter[i - 1][j], counter[i][j - 1]) + nums[i][j];
            }
        }
        return counter[len - 1][wid - 1];
    }

}