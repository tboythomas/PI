public class GasStation {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */

    // note: greedy. reset counter when the gas-cost < 0.
    // 
    public int canCompleteCircuit(int[] gas, int[] cost){
    	//corner case:
    	if(gas == null || gas.length == 0 || cost == null || cost.length == 0){
    		return 0;
    	}
    	int total_gas = 0;
    	int counter = -1;
    	int sum = 0;
    	for(int i = 0; i < gas.length; i ++){
    		total_gas += gas[i] - cost[i];
    		sum += gas[i] - cost[i];
    		if(total_gas < 0){
    			total_gas = 0;
    			counter = i;
    		}
    	}
    	if(sum < 0){
    	    return -1;
    	}else{
    		return counter + 1;
    	}
    }


    // note: O(n^2) 
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	if(gas == null || gas.length == 0 || cost == null || cost.length == 0){
    		return 0;
    	}
    	int len = gas.length;
    	int counter = -1;
    	int c_gas = 0;
    	for(int i = 0; i < gas.length; i++){
    	// start from every station
    		int j = i;
    		c_gas = gas[j];
    		while(c_gas >= cost[j]){
    			// minus the cost
    			c_gas -= cost[j];
    			j = (j + 1) % len;
    			c_gas += gas[j];
    			if(j == i){
    				counter = i;
    				break;
    			} 
    		}
    	}
    	return counter;
    }
}
