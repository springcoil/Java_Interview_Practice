import java.lang.Math;
public class Main {
    public int getMaxProfit(int[] stockPricesYesterday)
    {
    if (stockPricesYesterday.length < 2) {
        throw new IllegalArgumentException("Getting a profit involves at least two prices");
    }
    // we'll greedily update minPrice and maxProfit, so we initialize
    // them to the first price and the first possible profit
    int minPrice = stockPricesYesterday[0];
    int maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];
    // start at the second (index 1) time
    // we can't sell at the first time, since we must buy first// and we can't buy and sell at the same time
    for (int i =1; i < stockPricesYesterday.length; i++){
        int currentPrice = stockPricesYesterday[i];

        // see what our profit would be if we bought at the
        // min price and sold at the current price
        int potentialProfit = currentPrice - minPrice;

        maxProfit = Math.max(maxProfit, potentialProfit);
        minPrice = Math.min(minPrice, currentPrice);
    }
    return maxProfit;
    }
}