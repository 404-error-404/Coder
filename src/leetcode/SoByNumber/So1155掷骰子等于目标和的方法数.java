package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 * <p>
 * 给定三个整数 n ,  k 和 target ，返回可能的方式(从总共 kn 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。
 * <p>
 * 答案可能很大，你需要对 109 + 7 取模 。
 * <p>
 * https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/?envType=daily-question&envId=2023-10-24
 *
 * @author 小乐乐
 * @date 2023/10/24 21:08
 **/
public class So1155掷骰子等于目标和的方法数 {
    int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        if (target > k * n || target < n) {
            return 0;
        }
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int x = 1; x <= k; x++) {
                    if (j - x < 0) {
                        break;
                    }
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % MOD;

                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[n][target];
    }

    @Test
    public void test() {
        System.out.println(numRollsToTarget(3, 6, 14));
    }
}
