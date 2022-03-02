package leetcode.数组;

import org.junit.jupiter.api.Test;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/2 15:28
 */
public class So209长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = 0;
        int sum = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                right = i;
                minLen = i + 1;
                break;
            }
        }
        // 无解
        if (sum < target) {
            return 0;
        }
        // 滑动窗口直到最右侧
        while (right < nums.length - 1) {
            if (sum >= target) {
                sum -= nums[left];
                left++;
            } else {
                right++;
                sum += nums[right];
            }
            if (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
            }
        }
        // 滑到最右侧时看是否能继续缩小左侧窗口
        while (sum >= target) {
            minLen = Math.min(minLen, right - left + 1);
            sum -= nums[left];
            left++;
        }
        return minLen;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
}
