package leetcode.贪心;

import org.junit.jupiter.api.Test;

/**
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/4 23:47
 **/
public class So714买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        // 下跌超过fee就是卖点
        int res = 0;
        int start = 0;
        int end = -1;
        for (int i = 1; i < prices.length; i++) {
            if (end == -1) {
                if (prices[i] < prices[start]) {
                    start = i;
                } else if (prices[i] > prices[start] + fee) {
                    end = i;
                }
            } else {
                if (prices[i] < prices[end] - fee) {
                    res += prices[end] - prices[start] - fee;
                    start = i;
                    end = -1;
                } else if (prices[i] > prices[end]) {
                    end = i;
                }
            }
        }
        if (end != -1) {
            res += prices[end] - prices[start] - fee;
        }
        return res;
    }

    @Test
    public void test() {
        int[] prices = new int[]{1, 3, 7, 5, 10, 3};
        int fee = 3;
        System.out.println(
                maxProfit(prices, fee)
        );
    }
}
