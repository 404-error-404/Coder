package leetcode.动态规划;

import org.junit.jupiter.api.Test;

/**
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * @author 小乐乐
 * @date 2023/11/7 21:27
 **/
public class So309买卖股票的最佳时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[1][0] = -prices[0];
        for (int i = 2; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i - 1]);
            dp[i][1] = Math.max(dp[i][0] + prices[i - 1], dp[i - 1][1]);
        }
        return dp[prices.length][1];
    }

    @Test
    public void test() {
        int ans = maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(ans);
    }
}
