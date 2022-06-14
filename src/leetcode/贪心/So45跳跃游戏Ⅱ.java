package leetcode.贪心;

import org.junit.jupiter.api.Test;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/6/2 14:41
 */
public class So45跳跃游戏Ⅱ {
    public int jump2(int[] nums) {
        int steps = 0;
        int cur = 0;
        int max = 0;
        int lastIdx = nums.length - 1;

        while (max < lastIdx) {
            steps++;
            int temp = max;
            while (cur <= max) {
                temp = Math.max(temp, cur + nums[cur]);
                cur++;
            }
            max = temp;
        }
        return steps;
    }

    public int jump(int[] nums) {
        int[] res = new int[nums.length];
        // 令初始位置步数为1，其他位置0表示不可到达
        res[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if (res[i] == 0) {
                continue;
            }
            for (int j = 1; j <= nums[i]; j++) {
                int idx = i + j;
                if (idx == nums.length) {
                    break;
                }
                if (res[idx] == 0) {
                    res[idx] = res[i] + 1;
                } else {
                    res[idx] = Math.min(res[idx], res[i] + 1);
                }
            }
        }
        return res[nums.length - 1] - 1;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 0, 1, 4};
        System.out.println(jump2(nums));
    }
}
