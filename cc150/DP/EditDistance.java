public class EditDistance{
    /*
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */

    // note: Levenshtein Distance
    // explianation:
    //(http://baike.baidu.com/link?url=EdlCdcc_4E0evwodGvjJZFgdnAQia-JfTGzVOfbWDQlMnjP0pAY2Qa9MYHBNb6DgLBdnMVliFGubB4KIlTiYLq8FPAL3O_Eow1j48o_uKx8jHeSvIP1hCVDnTqiEqppL0RoIaiYDYtb3yMRSDO9jqLYdlQ6lkbjcXSkwfJiVy6C#2_1)
    // construct a int[][] as counter, assign the index first
    // for each char, if the char at two strings in the same index
    // is the same, cost is zero, otherwise it is 1. 
    // assign the min value from (top-left corner val + cost, left-value + 1, top- value + 1)
    public int minDistance(String word1, String word2) {
    	if(word1 == null || word2 == null){
    		return -1;
    	}
    	if(word1.length() == 0){
    		return word2.length();
    	}
    	if(word2.length() == 0){
    		return word1.length();
    	}
    	if(word1.equals(word2)){
    		return 0;
    	}
    	int len1 = word1.length();
    	int len2 = word2.length();
    	int[][] counter = new int[len1 + 1][len2 + 1];
    	for(int i = 0; i < len1 + 1; i++){
    		counter[i][0] = i;
    	}
    	for(int j = 0; j < len2 + 1; j ++){
    		counter[0][j] = j;
    	}
    	for(int k = 1; k < len1 + 1; k ++){
    		char temp = word1.charAt(k - 1);
    		for(int h = 1; h < len2 + 1; h++){
    			char temp2 = word2.charAt(h - 1);
    			int cost = 1;
    			if(temp == temp2){
    			    cost = 0;
    			}
    			// find the min from, top-left corner + cost, top val + 1, left val + 1
    			counter[k][h] = min(counter[k - 1][h - 1] + cost, counter[k - 1][h] + 1, counter[k][h - 1] + 1);
    		}
    	}
    	return counter[len1][len2];
    }

    private int min(int a, int b, int c){
    	int min_val= Math.min(Math.min(a,b),c);
    	return min_val;
    }
}