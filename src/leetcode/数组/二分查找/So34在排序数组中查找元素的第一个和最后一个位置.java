package leetcode.数组.二分查找;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/1 15:02
 */
public class So34在排序数组中查找元素的第一个和最后一个位置 {
    /**
     * 查找左边界，保证left < right，且nums[right] == target
     *
     * @param nums   已排序的数组
     * @param target 目标值
     * @param left   当前范围的左边界
     * @param right  当前范围的右边界
     * @return 左边界
     */
    int findLeftRange(int[] nums, int target, int left, int right) {
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 保证nums[right] == target恒成立
                right = mid;
            }
        }
        return right;
    }

    /**
     * 查找右边界，保证left < right，且nums[left] == target
     *
     * @param nums   已排序的数组
     * @param target 目标值
     * @param left   当前范围的左边界
     * @param right  当前范围的右边界
     * @return 右边界
     */
    int findRightRange(int[] nums, int target, int left, int right) {
        int mid;
        while (left < right) {
            mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // 保证nums[left] == target恒成立
                left = mid;
            }
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) {
            return res;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left > right) {
            return res;
        }
        // 未找到等于target的mid
        if (left == right) {
            if (nums[left] == target) {
                res[0] = left;
                res[1] = right;
            }
            return res;
        }
        // 找到等于target的mid
        // 在 [left, mid] 寻找左边界
        res[0] = findLeftRange(nums, target, left, mid);
        // 在 (mid, right] 寻找右边界
        res[1] = findRightRange(nums, target, mid, right);
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        nums = new int[]{2, 2};
        target = 1;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
