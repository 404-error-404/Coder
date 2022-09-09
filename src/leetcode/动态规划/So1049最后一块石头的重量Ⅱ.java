package leetcode.动态规划;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/last-stone-weight-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/8 17:00
 */
public class So1049最后一块石头的重量Ⅱ {
    public int lastStoneWeightII(int[] stones) {
        Arrays.sort(stones);
        int sum = Arrays.stream(stones).sum();
        int[][] dp = new int[sum / 2 + 1][stones.length];
        for (int i = 1; i <= sum / 2; i++) {
            for (int j = 0; j < stones.length; j++) {
                if (j == 0) {
                    if (stones[j] > i) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = stones[j];
                    }
                } else {
                    if (stones[j] > i) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - stones[j]][j - 1] + stones[j]);
                    }
                }
            }
        }
        return sum - dp[sum / 2][stones.length - 1] * 2;
    }

    @Test
    public void test() {
        int[] stones = new int[]{1, 2, 4, 8, 16, 32, 64, 12, 25, 51};
        stones = new int[]{31, 26, 33, 21, 40};
        stones = new int[]{2, 7, 4, 1, 8, 1};
        stones = new int[]{21, 60, 61, 20, 31};
        System.out.println(
            lastStoneWeightII(stones)
        );
    }
}
