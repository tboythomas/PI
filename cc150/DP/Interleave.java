public class Interleave {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */

    // note: 
    // initial state: """ is true
    // for single string s1, if s1[i] = s3[i] and previous s1[i] is true, s3[i] is prefix(s1) 
    // transformation function : s3[0: n]  = s1[0:i] + s2[0:j]
    public boolean isInterleave(String s1, String s2, String s3) {
		if(s3.length() != s2.length() + s1.length()){
			return false;
		}
		int len1 = s1.length();
		int len2 = s2.length();
		boolean[][] counter = new boolean[len1 + 1][len2 + 1];
		counter[0][0] = true;
		for(int i = 1; i < len1 + 1; i++){
			if(s1.charAt(i -1) == s3.charAt(i -1) && counter[i -1][0]){
				counter[i][0] = true;
			}
		}
		for(int j = 1; j < len2 + 1; j++){
			if(s2.charAt(j -1) == s3.charAt(j -1)&& counter[0][j-1]){
				counter[0][j] = true;
			}
		}
		for(int i = 1; i < len1 + 1; i ++){
			for(int j = 1; j < len2 + 1; j++){
				// check for s3[i] with s1[i] and s1[0:i - 1]
				if((s3.charAt(i + j - 1) == s1.charAt(i - 1) && counter[i - 1][j])){
				    counter[i][j] = true;
				}
				// check for s3[i] with s2[i] and s2[0:i - 1]
				if((s3.charAt(i + j -1) == s2.charAt(j - 1) && counter[i][j - 1])){
					counter[i][j] = true;
				}
			}
		}
        return counter[len1][len2];
    }
}
