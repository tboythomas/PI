// solution manpage: http://www.tuicool.com/articles/rMJZj2
public class StockI {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
        	return 0;
        }
        // buy first
        int min = prices[0];
        int max_profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] - min > max_profit){
                max_profit = prices[i] - min;
            }
        }
        return max_profit;
    }
}

//-------------------------------stockII
// not limit number of operations
public class StockII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
        	return 0;
        }
        int profit = 0;
        for(int i = 1; i < prices.length; i ++){
        	//there is profit
        	if(prices[i] > prices[i - 1]){
        		profit += prices[i] - prices[i - 1];
        	}
        }
        return profit;
    }
}