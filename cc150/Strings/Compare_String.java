public class Compare_String{
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */

    //use int array(length 256) as counter to record the number of char in each string and then compare then
 	  public static boolean compareStrings(String A, String B) {
	    	if(A == null && B != null){
	    		return false;
	    	}
	    	if(B == null){
	    		return true;
	    	}
	    	//use boolean as counter to compare the strings
	    	int[] b1 = new int[256];
	    	for(int i = 0; i< A.length(); i++){
	    		char temp = A.charAt(i);
	    		b1[temp]++;
	    	}

	    	for(int i = 0; i<B.length(); i++){
	    		char temp = B.charAt(i);
	    		b1[temp]--;
	    		if(b1[temp] < 0){
	    			return false;
	    		}
	    	}
	    	return true;
	}
}