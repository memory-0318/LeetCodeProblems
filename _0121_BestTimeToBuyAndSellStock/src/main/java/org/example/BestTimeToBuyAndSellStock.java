package org.example;

/**
 * @author Brian Su <memory0318@gmail.com>
 * @description:
 * @date: 2022/10/16
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowestPrice = prices[0];

        for (int idx = 1; idx < prices.length; ++idx) {
            int price = prices[idx];
            if (price < lowestPrice) {
                lowestPrice = prices[idx];
            }

            int priceChange = price - lowestPrice;
            if (priceChange > maxProfit) {
                maxProfit = priceChange;
            }
        }

        return maxProfit;
    }
}
