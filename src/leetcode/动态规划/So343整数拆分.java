package leetcode.动态规划;

import org.junit.jupiter.api.Test;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/5 15:48
 */
public class So343整数拆分 {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        // dp[i] = max(dp[i-2] * 2, dp[i-3] * 3)
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(integerBreak(58));
    }
}