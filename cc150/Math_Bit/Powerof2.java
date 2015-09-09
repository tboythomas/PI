class Powerof2 {
    /*
     * @param n: An integer
     * @return: True or false
     */
    

    // note: power of 2 only have one 1 in bits.
    // method: check n&(n-1)
    // ex:
    // n = 5     a =  101
    // n -1 = 4  b =  100
    // 		   a&b =  100
    // n = 8     a = 1000
    // n-1 = 7   b = 0111
    //         a&b = 0000 			
    public boolean checkPowerOf2(int n) {
    	if(n > 0){
    		int temp = n & (n - 1);
    		if(temp == 0){
    			return true;
    		}
    	}
    	return false;
    }
};
