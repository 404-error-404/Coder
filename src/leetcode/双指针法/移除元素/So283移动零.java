package leetcode.双指针法.移除元素;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/move-zeroes">https://leetcode-cn.com/problems/move-zeroes</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/18 21:25
 **/
public class So283移动零 {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        int len = nums.length;
        while (right < len) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        while (left < len) {
            nums[left] = 0;
            left++;
        }
    }
}
