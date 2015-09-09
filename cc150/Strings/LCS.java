public class LCS {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */

    // use an martix[A.length + 1][B.length + 1] to record the identical char, add 1 to the value on 
    // the left corner, watch out the boundry value of the second for loop 
   public int longestCommonSubstring(String A, String B) {
      if(A == null || B == null){
         return 0;
      }
   
      int len1 = A.length();
      int len2 = B.length();
      int[][] table = new int[len1+1][len2+1];
   
      for(int i = 0; i < len1 + 1; i++){
         table[i][0] = 0;
      }
      // ?
      for(int j = 0; j< len2 + 1; j++){
         table[0][j] = 0;   
      }
      int max = 0;
      //note: [0,0] is wasted. for lining up, we have to start with 1
      for(int i = 1; i <= len1; i++ ){
         for(int j = 1; j <= len2; j++){
            if(A.charAt(i-1) == B.charAt(j -1)){
               table[i][j] = table[i-1][j-1] + 1;
               if(table[i][j] > max){
                  max = table[i][j];
               }
            }
         }
      }
      return max;
   }
}
