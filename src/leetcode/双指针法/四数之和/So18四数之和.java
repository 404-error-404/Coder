package leetcode.双指针法.四数之和;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/4sum">https://leetcode-cn.com/problems/4sum</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/12 12:32
 **/
public class So18四数之和 {
    /**
     * 获取与当前下标元素相等的边界
     * next=1表示右边界，next=-1表示左边界
     * 如nums=[1,1,1,2,3,4], idx=2, next=1
     * 意为求nums[2]=1元素的右边界，返回3
     */
    int getSameIntEdge(int[] nums, int idx, int next) {
        int nextIdx = idx + next;
        while (nextIdx >= 0 && nextIdx < nums.length) {
            if (nums[nextIdx] != nums[idx]) {
                return idx;
            } else {
                idx = nextIdx;
                nextIdx = idx + next;
            }
        }
        return idx;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int diff = target - nums[i] - nums[j];
                int left = j + 1, right = len - 1;
                while (left < right) {
                    int tempSum = nums[left] + nums[right];
                    if (tempSum == diff) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left = getSameIntEdge(nums, left, 1) + 1;
                        right = getSameIntEdge(nums, right, -1) - 1;
                    } else if (tempSum < diff) {
                        left = getSameIntEdge(nums, left, 1) + 1;
                    } else {
                        right = getSameIntEdge(nums, right, -1) - 1;
                    }
                }
                j = getSameIntEdge(nums, j, 1);
            }
            i = getSameIntEdge(nums, i, 1);
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 0, -1, 0, -2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(fourSum(nums, 0));
    }
}
