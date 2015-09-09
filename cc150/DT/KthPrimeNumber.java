class KthPrimeNumber {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */

    // note: for every prime number, it is multiplied by 3 or 5 or 7 with previous prime number
    // (3, 5, 7 , 9(3*3),15(3*5), 21(3*7),25(5*5),35(5*7)...)
  	// increment the counter if the number matches
    public long kthPrimeNumber(int k) {
        if(k < 3){
        	return 3;
        }
        long[] counter = new long[k + 1];
        counter[0] = 1;
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;
        for(int i = 1; i < counter.length; i++){
        	counter[i] = Math.min(Math.min(counter[p3] * 3, counter[p5] * 5), counter[p7] * 7);
        	if(counter[i] == counter[p3] * 3){
        		p3++;
        	}
        	if(counter[i] == counter[p5] * 5){
        		p5++;
        	}
           	if(counter[i] == counter[p7] * 7){
        		p7++;
        	}
        }
        return counter[k];
    }
};

