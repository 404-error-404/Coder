package leetcode.贪心;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/12 10:43
 */
public class So53最大子数组和 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int cur = Math.max(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            cur += nums[i];
            res = Math.max(cur, res);
            if (cur < 0) {
                cur = 0;
            }
        }

        return res;
    }
}
