package leetcode.动态规划;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/14 16:04
 */
public class So322零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i > coin && dp[i - coin] != 0) {
                    if (dp[i] == 0) {
                        dp[i] = dp[i - coin] + 1;
                    } else {
                        dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                    }
                }
                else if (i == coin) {
                    dp[i] = 1;
                }
            }
        }
        return dp[amount] == 0? -1: dp[amount];
    }

    @Test
    public void test() {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(
            coinChange(coins, amount)
        );
    }
}
