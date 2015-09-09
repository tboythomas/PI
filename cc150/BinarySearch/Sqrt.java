class Sqrt {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
  public int sqrt(int x) {
        // write your code here
    	long lo = 0;
    	long hi = x;
    	while(hi >= lo){
    		long mid = lo + (hi - lo)/2;
    		if(mid * mid > x){
    			hi = mid - 1;
    		}else{
    		    lo = mid + 1;
    		}
    	}
    	return (int)hi;
    }
}