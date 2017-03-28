/**
 * Created by jb039k on 3/28/2017.
 */
public class BestTimeToBuySellStockII {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i+1] > prices[i]){
                profit = profit + (prices[i+1] - prices[i]);
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {2,1,2,0,1};
        int profit = maxProfit(stockPrices);
        System.out.println(profit);
    }
}
