package leetcode.动态规划;

import org.junit.jupiter.api.Test;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/15 19:42
 */
public class So121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] - dp[i - 1][0]);
        }
        return dp[prices.length - 1][1];
    }

    public int maxProfit2(int[] prices) {
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                res = Math.max(prices[i] - min, res);
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(
            maxProfit(prices)
        );
        System.out.println(
            maxProfit2(prices)
        );
    }
}
