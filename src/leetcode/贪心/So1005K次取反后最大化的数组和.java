package leetcode.贪心;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * <p>
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * <p>
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/6/10 21:34
 **/
public class So1005K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        // 统计负数计数（从0开始）
        int i = 0;
        for (; i < k && i < nums.length && nums[i] < 0; i++) {
            nums[i] = -nums[i];
        }
        k = (k - i) % 2;
        // 1. 处理后全正数
        if (i == nums.length) {
            return Arrays.stream(nums).sum() - nums[nums.length - 1] * k * 2;
        }
        // 2. 处理前全正数
        else if (i == 0) {
            return Arrays.stream(nums).sum() - nums[0] * k * 2;
        }
        // 3. 有负数有正数
        else {
            return Arrays.stream(nums).sum() - Math.min(nums[i], nums[i - 1]) * 2 * k;
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{-4, -2, -3};
        int k = 1;
        System.out.println(largestSumAfterKNegations(nums, k));
    }
}
