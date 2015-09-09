class FlipBit{
    /**
     *@param a, b: Two integer
     *return: An integer
     */
  public static int bitSwapRequired(int a, int b) {
        int c = a ^ b;
        int count = 0;
        if (c < 0) {
            count++;
            c = Integer.MIN_VALUE ^ c;
        }
        while(c != 0) {
            count += c%2;
            c = c/2;
        }
        return count;
    }
};

