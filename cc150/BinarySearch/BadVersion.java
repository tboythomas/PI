/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class BadVersion {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    // note: binary search. If version(mid) is true, first bad version is in the left part.
    // otherwise it is on the right part.
    public int findFirstBadVersion(int n) {
    	if(n == 1){
    		return 1;
    	}
    	int low = 1;
    	int high = n;
    	while(low <= high){
    		int mid = (low + high) /2;
    		if(VersionControl.isBadVersion(mid)){
    			high = mid -1;
    		}else{
    			low = mid + 1;
    		}
    	}
    	return low;
    }
}