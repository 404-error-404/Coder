package leetcode.双指针法.移除元素;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/18 22:49
 **/
public class So977有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        int idx = nums.length - 1;
        while (left < right) {
            int leftAbs = Math.abs(nums[left]);
            int rightAbs = Math.abs(nums[right]);
            if (leftAbs > rightAbs) {
                left++;
                res[idx] = leftAbs * leftAbs;
            } else {
                res[idx] = rightAbs * rightAbs;
                right--;
            }
            idx--;
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {-25, -5, -4, 0, 1, 4, 5, 25};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
