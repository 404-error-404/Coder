package leetcode.贪心;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2022/5/26 23:02
 **/
public class So122买卖股票的最佳时机Ⅱ {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0], max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 遇到递减区间
            if (prices[i] < prices[i-1]) {
                res += max - min;
                max = prices[i];
                min = prices[i];
            }
            else {
                max = Math.max(max, prices[i]);
                min = Math.min(min, prices[i]);
            }
        }
        res += max - min;
        return res;
    }
}
