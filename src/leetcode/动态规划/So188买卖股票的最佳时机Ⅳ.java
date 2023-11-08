package leetcode.动态规划;

import org.junit.jupiter.api.Test;

/**
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * @author 小乐乐
 * @date 2023/11/6 17:42
 **/
public class So188买卖股票的最佳时机Ⅳ {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int j = 1; j <= k; j++) {
            dp[0][j * 2 - 1] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                // j*2-1: 本次记录第n次操作的最大收益
                dp[i][j * 2 - 1] = Math.max(dp[i - 1][j * 2 - 1], dp[i][j * 2 - 2] - prices[i]);
                // 比较第n次卖出的最大收益
                dp[i][j * 2] = Math.max(dp[i - 1][j * 2], dp[i][j * 2 - 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][k * 2];
    }

    @Test
    public void test() {
        int ans = maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
        System.out.println(ans);
    }
}
