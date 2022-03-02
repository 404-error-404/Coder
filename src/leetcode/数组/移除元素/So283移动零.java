package leetcode.数组.移除元素;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/2 18:33
 **/
public class So283移动零 {
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        int temp;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                // 使用temp防止fast=slow时，将fast位归零，如：nums = [1]
                temp = nums[fast];
                nums[fast] = 0;
                nums[slow] = temp;
                slow++;
            }
            fast++;
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
