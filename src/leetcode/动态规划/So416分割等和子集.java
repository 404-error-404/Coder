package leetcode.动态规划;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/6 18:15
 */
public class So416分割等和子集 {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 == 1) {
            return false;
        }
        Arrays.sort(nums);
        int[] dp = new int[total / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j > nums[i]; j--) {
                dp[j] = Math.max(dp[j - nums[i]] + nums[i], dp[j]);
            }
        }
        return dp[total / 2] == total / 2;
//        int[][] dp = new int[total / 2 + 1][nums.length];
//        // 背包容量m，物品重量n
//        for (int i = 1; i < dp.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[j] > i) {
//                    if (j >= 1) {
//                        dp[i][j] = dp[i][j - 1];
//                    }
//                } else {
//                    // 放物品j时的最大容量dp[i-nums[j]][j-1] + nums[j]
//                    // 不放物品j时的最大容量dp[i][j-1]
//                    if (j >= 1) {
//                        dp[i][j] = Math.max(dp[i - nums[j]][j - 1] + nums[j], dp[i][j - 1]);
//                    } else {
//                        dp[i][j] = nums[j];
//                    }
//                }
//            }
//        }
//        return dp[total / 2][nums.length - 1] == total / 2;
    }

    @Test
    public void test() {
        int[] nums = new int[]{23, 13, 11, 7, 6, 5, 5};
        System.out.println(
            canPartition(nums)
        );
    }
}
