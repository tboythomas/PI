public class SingerNumber {
	/**
	 *@param A : an integer array
	 *return : a integer 
	 */

	// note: use bit manipulation.
	// ex:[1,2,2,3,3]
	// 1 ^ 2 = 3, 3^2 = 1, 1 ^3 = 2, 2^3 = 1
	public int singleNumber(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int n = A[0];
		for(int i = 1; i < A.length; i++) {
			n = n ^ A[i];
		}
		return n;
	}
}
