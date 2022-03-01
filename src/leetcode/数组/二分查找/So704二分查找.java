package leetcode.数组.二分查找;

import org.junit.jupiter.api.Test;

/**
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/1 13:58
 */
public class So704二分查找 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            // 防止溢出
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    @Test
    public void test() {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        nums = new int[]{1, 2};
        int target = 9;
        System.out.println(search(nums, target));

    }
}
