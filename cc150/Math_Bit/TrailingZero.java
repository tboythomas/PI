class TrailingZero {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */

    // note: think about what makes a 0 in multiplication.
  	// keep dividing 5 and add the result together.
    public long trailingZeros(long n) {
        if(n < 0){
        	return 0;
        }
        // use int will lead to a wrong answer when n is very large.
        long result = 0;
        while(n / 5 !=0 ){
        	result += n /5;
        	n = n/5;
        }
        return result;
    }
};
