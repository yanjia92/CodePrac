package cn.jccomp.dp;

/**
 * Created by bitbook on 3/27/18.
 * 股票最大收益问题
 */
public class MaximumProfit {

    // 只容许一次买卖
    int oneTransaction(int[] prices) {
        int finalBuy = Integer.MAX_VALUE;
        int finalSell = Integer.MAX_VALUE;
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            if (price < buy) {
                finalBuy = buy = price;
            }
            profit = (price-buy)>profit ? (price-buy) : profit;
        }
        return profit;
    }



}
