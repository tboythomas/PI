public class ClimbStairs{
    /**
     * @param n: An integer
     * @return: An integer
     */

    //note:
    // n = 0,  0 way
    // n = 1,  1 way
    // n = 2, 1,1 or 2 --> 2 ways
    // n > 2, 1 step first, f(n-1) way
    //        2 steps first, f(n-2) way
    // f(n) = f(n-2) + f(n-1)
	/*
	for example, n is 4,
	choose 1 step first, f(n-1) = f(3), 1,1,1 / 2,1 / 1,2 with the first 1 step
	choose 2 steps first, f(n-2) = f(2), 1,1/ 2 with the first 2 steps
	f(4) = f(3) + f(2) = 5
	*/
    public int climbStairs(int n) {
		if(n <= 2){
			return n;
		}
		int[] counter = new int[n + 1];
		// n = 1, for understanding, counter[0] is wasted
		counter[1] = 1;
		// n = 2
		counter[2] = 2;
		for(int i = 3; i < n + 1; i ++){
			counter[i] = counter[i - 1] + counter[i - 2];
		}
		return counter[n];
    }
}
