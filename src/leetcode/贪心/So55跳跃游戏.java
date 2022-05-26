package leetcode.贪心;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/26 23:03
 **/
public class So55跳跃游戏 {
    public boolean canJump(int[] nums) {
        boolean[] res = new boolean[nums.length];
        res[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (res[i]) {
                for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                    res[i + j] = true;
                }
            }
        }
        return res[nums.length - 1];
    }
}
