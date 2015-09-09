class FastPower {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    
    // note: 
    // (a * b) % p = ((a % p) * (b % p)) % p
    // use recursion. a^n = a^n/2 * a^n/2 = a^n/4 * a^n/4 * a^n/4 * a^n/4 .....
    // find product. wheh n = 1, return a % b;
    // if n is odd number, multiply A again at the end
    public int fastPower(int a, int b, int n) {
    	// coner case: if a^0 = 1, return b % 1
        if(n == 1){
    		return a % b;
    	}else if(n == 0){
    	    return 1 % b;
    	}
    	long product = fastPower(a, b, n / 2);
    	product = (product * product) % b;
    	if(n % 2 == 1){
    		product = (a * product) % b;
    	}
    	return (int) product; 
    }
};