package leetcode.动态规划;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/9 10:31
 */
public class So494目标和 {
    int res = 0;

    private void backtracking(int[] nums, int target, int idx, int sum) {
        if (idx == nums.length) {
            res += sum == target ? 1 : 0;
        } else {
            sum += nums[idx];
            backtracking(nums, target, idx + 1, sum);
            sum -= nums[idx] * 2;
            backtracking(nums, target, idx + 1, sum);
        }
    }

    public int findTargetSumWays1(int[] nums, int target) {
        res = 0;
        backtracking(nums, target, 0, 0);
        return res;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        target = (sum + target) / 2;
        if (target > sum || target < 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int n : nums) {
            for (int i = target; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[target];
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;

        nums = new int[]{1};
        target = 1;

        nums = new int[]{7, 9, 3, 8, 0, 2, 4, 8, 3, 9};
        target = 0;

        System.out.println(
            findTargetSumWays(nums, target)
        );
    }
}
