/***
Given string A representative a positive integer which has N digits, remove any k digits of the number, the remaining 
digits are arranged according to the original order to become a new positive integer.
Find the smallest integer after remove k digits.

N <= 240 and k <= N
***/

public class DeleteDigits {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */

    // note: 
    // use two for loop, inner loop need to find the index i such that char[i]> char[i + 1]
    // corner case: when i == str.length -1, means that the string is ascending, so target index
    // is length - 1
    // the outer loop is to perform the deletion k times. and at the end remove the 0 at front.
    
    public String DeleteDigits(String A, int k) {
        if(A == null || A.length() == 0){
            return "0";
        }
        for(int i = 0 ; i < k; i ++){
            for(int j = 0; j < A.length(); j++){
                // corner case : strictly ascending
                if(j == A.length() - 1 || A.charAt(j) > A.charAt(j+1)){
                    A = remove(A, j);
                    break;
                }
            }
        }
        // remove 0 at front
        int i =0;
        while(i < A.length() && A.charAt(i) == '0'){
            i++;
        }
        
        return A.substring(i, A.length());
    }
    
    // remove the target char
    public String remove(String result, int pos){
        if(pos == result.length() -1){
            return result.substring(0, result.length() - 1);
        }
        return result.substring(0,pos) + result.substring(pos+1, result.length());
    }
}
