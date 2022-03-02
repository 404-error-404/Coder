package leetcode.数组;

import org.junit.jupiter.api.Test;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/2 14:21
 */
public class So27移除元素 {
    public int removeElement(int[] nums, int val) {
        int p_index = 0;
        int real_index = 0;

        for (; p_index < nums.length; p_index++) {
            if (nums[p_index] != val) {
                nums[real_index] = nums[p_index];
                real_index++;
            }
        }
        return real_index;
    }

    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }
}
