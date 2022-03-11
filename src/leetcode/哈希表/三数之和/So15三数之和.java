package leetcode.哈希表.三数之和;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/11 20:03
 */
public class So15三数之和 {
    public int nextLeft(int[] nums, int left) {
        while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
            left++;
        }
        return left + 1;
    }

    public int nextRight(int[] nums, int right) {
        while (right > 0 && nums[right] == nums[right - 1]) {
            right--;
        }
        return right - 1;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return res;
        }
        int left, right;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return res;
            }
            // 查找nums[i]对应的另外两个数是否存在
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int diff = -nums[i];
                int temp = nums[left] + nums[right];
                if (temp == diff) {
                    List<Integer> element = new ArrayList<>();
                    element.add(nums[i]);
                    element.add(nums[left]);
                    element.add(nums[right]);
                    res.add(element);
                    left = nextLeft(nums, left);
                    right = nextRight(nums, right);
                } else if (temp < diff) {
                    left = nextLeft(nums, left);
                } else {
                    right = nextRight(nums, right);
                }
            }
            // i移动到下一个不同的数
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{-2, 0, 0, 2, 2};
        System.out.println(threeSum(nums));
    }
}
