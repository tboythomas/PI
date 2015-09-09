
public class LCP {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
	
    // 1. take one string from the list (corner case: if len ==1, return only string, if == 0 or null, return "")
    // 2. compare the char in that string to other strings in the list
    // 3. longest common prefix length <= shortest string in the list
    // 4. if char not equal or there is a string length < the common prefix -> jump out of the loop.
	public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0){
    		return "";
    	}
        if(strs.length == 1){
            return strs[0];
        }
    	// rank the strs from shortest to longest
      // note: if we dont sort the array here, in line 29, we need to make sure that strs[j].length > len
    	Arrays.sort(strs);

    	String s = strs[0];
    	int len = s.length();

    	for(int i = 0 ; i < len; i++){
    		char temp = s.charAt(i);
  			for(int j = 1; j < strs.length; j++){
  				if(temp != strs[j].charAt(i)){
  					return s.substring(0,i);
  				}
  			}
    	}
    	return s;
    }
}
