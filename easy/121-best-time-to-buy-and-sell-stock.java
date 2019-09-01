class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minBuy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(prices[i] - minBuy, profit);
            minBuy = Math.min(minBuy, prices[i]);
        }
        return profit;
    }
}
