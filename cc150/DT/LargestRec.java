public class LargestRec{
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
    	if(height == null || height.length == 0){
    		return 0;
    	}
    	int area = 0;
    	for(int i = 0; i < height.length; i++){
    		// find higher rec
    		for(int j = i + 1; j < height.length; j++){
    			if(height[j] >= height[i]){
    				i = j;
    			}else{
    				i = j - 1;
    				break;
    			}
    		}
    		int lowest = height[i];
    		for(int k = i; k >= 0; k --){
    			if(height[k] < lowest){
    				lowest = height[k];
    			}
    			int curArea = (i - k + 1) * lowest;
    			if(curArea > area){
    				area = curArea;
    			}
    		}
    	}
    	return area;
    }

    //---------Use a stack to optimize this solution
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
   public int largestRectangleArea(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }
        // use a stack to store index
        Stack<Integer> counter = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i <= height.length; i ++){
            // when reach the end, we still need to calculate the area, so set cur = -1, 
            //  we could calculate the whole array
            int current = (i == height.length) ? -1 : height[i];
            while(!counter.isEmpty() && current <= height[counter.peek()]){
                int len = height[counter.pop()];
                // if counter is empty, means that wid is i 
                // (since len has poped one element, so the counter.peek() decrement 1 each time )
                int wid = counter.isEmpty() ? i : i - counter.peek() - 1;
                max = Math.max(max, len * wid); 
            }
            counter.push(i);
        }
        return max;
    }

}
}