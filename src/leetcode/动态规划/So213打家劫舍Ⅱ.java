package leetcode.动态规划;

import org.junit.jupiter.api.Test;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/15 17:36
 */
public class So213打家劫舍Ⅱ {
    public int robCopy(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    public int rob(int[] nums) {
        switch (nums.length) {
            case 0:
                return 0;
            case 1:
                return nums[0];
            default:
                int[] tmp = new int[nums.length - 1];
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = nums[i];
                }
                int res = robCopy(tmp);
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = nums[i+1];
                }
                return Math.max(res, robCopy(tmp));
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 2};
        System.out.println(
            rob(nums)
        );
    }
}
