public WordBreak {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
    	if(s == null || s.length() == 0){
    		return true;
    	}
    	if(dict == null || dict.size() == 0){
    		return false;
    	}
    	int len = s.length();
    	boolean [] counter = new boolean[len + 1];
    	// F(0, N)  = F(0, j) + F(j, N)
    	counter[0] = true;
    	int max = getmax(dict);
    	for(int i = 1; i < len + 1; i ++){
    		// this will cuz TLE, use an optizimation.
    		// the max length the word can be breaked is the max length of words from the dict
    		// if j > max, no need to check for substring.
    		for(int j = 1; j <= i && j <= max ; j ++){
    		    // F(0, j) && F(j,N)
    			if(counter[i-j] && dict.contains(s.substring(i-j,i))){
    				counter[i] = true;
    			}
    		}
    	}
    	return counter[len];
    }

    private int getmax(Set<String> dict){
    	int max = Integer.MIN_VALUE;
    	for(String temp: dict){
    		if(temp.length() > max){
    			max = temp.length();
    		}
    	}
    	return max;
    }
}