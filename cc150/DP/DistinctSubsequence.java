public class DistinctSubsequence {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */

    // note: 
    // construct a int[][] array, assign a[i][0] to 1, cuz when target is '', the 
    // only choice it to delete the char to match ''. 
    // when s.charAt(i) == t.charAt(j), dp[i][j] can match (continue to match) charAt[i -1][j -1] 
    // or (go back to previous char)charAt[i-1][j]
    // s.charAt(i) != t.chatAt(j), dp[i][j] can only be go back to previous char(charAt[i-1][j])
    public int numDistinct(String s, String target) {
    	if(s == null || target == null || s.length() < target.length()){
    		return 0;
    	}
    	if(target.length() == 0){
    		return 1;
    	}
    	int len1 = s.length();
    	int len2 = target.length();
    	int[][] counter = new int[len1 + 1][len2 + 1];
    	for(int i  = 1; i < len1 + 1; i ++){
    		counter[i-1][0] = 1;
    		for(int j = 1; j < len2 + 1; j++){
    			if(s.charAt(i - 1) == target.charAt(j - 1)){
    				counter[i][j] = counter[i -1][j -1] + counter[i -1][j]; 
    			}else{
    				counter[i][j] = counter[i -1][j];
    			}
    		}
    	}
    	return counter[len1][len2];
    }
}