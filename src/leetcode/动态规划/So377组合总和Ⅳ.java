package leetcode.动态规划;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * <p>
 * 题目数据保证答案符合 32 位整数范围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/14 15:10
 */
public class So377组合总和Ⅳ {
    // TODO 这个没太明白，可以再做一做
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++){
            for (int num: nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        System.out.println(
            combinationSum4(nums, target)
        );
    }
}
