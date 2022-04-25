package leetcode.栈与队列;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/sliding-window-maximum">https://leetcode-cn.com/problems/sliding-window-maximum</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/23 14:48
 */
public class So239滑动窗口最大值 {
    /**
     * 在降序数组中找到目标值的插入位置
     *
     * @param nums   降序数组
     * @param target 目标值
     * @return 待插入位置
     */
    public int lowerBound(List<int[]> nums, int[] target) {
        int res = nums.size();
        int left = 0, right = res - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums.get(mid)[0] > target[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (res != 0 && nums.get(left)[0] <= target[0]) {
            res = left;
        }
        return res;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        // 对nums中的值降序存储
        List<int[]> sortedNums = new ArrayList<>();
        // 初始化前k个元素
        for (int i = 0; i < k - 1; i++) {
            // target[0]存储对应数值，target[1]存储对应下标
            int[] target = {nums[i], i};
            sortedNums.add(lowerBound(sortedNums, target), target);
        }
        for (int i = 0, right = k - 1; i < res.length; i++, right++) {
            // 将窗口右移新加入的值添加到降序list中
            int[] target = {nums[right], right};
            sortedNums.add(lowerBound(sortedNums, target), target);
            // 移除窗口左侧元素
            while (sortedNums.get(0)[1] < i) {
                sortedNums.remove(0);
            }
            // 添加当前窗口最大值
            res[i] = sortedNums.get(0)[0];
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 2};
        int k = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
