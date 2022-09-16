package leetcode.动态规划;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/16 14:14
 */
public class So122买卖股票的最佳时机Ⅱ {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            if (price <= min) {
                min = price;
            }
            else {
                res += price - min;
                min = price;
            }
        }
        if (prices[prices.length - 1] > min) {
            res += prices[prices.length - 1] - min;
        }
        return res;
    }
}
