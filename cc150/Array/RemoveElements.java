public class RemoveElements {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */

    // use one pointer to track target from back to front, another index to track target from front, when index == pointer, return the length.
    public int removeElement(int[] A, int elem) {
        int i = 0;
        int pointer = A.length - 1;
        while(i <= pointer){
            if(A[i] == elem){
                A[i] = A[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer + 1;
    }
    
    // method 2: one pointer to track ele != val
    public int removeElement(int[] A, int elem){
        if(A == null || A.length == 0){
            return 0;
        }
        int ind = 0;
        for(int i = 0; i < A.length; i ++){
            if(A[i] != elem){
                A[ind++] = A[i];
            }   
        }
        return ind;
    }
}

