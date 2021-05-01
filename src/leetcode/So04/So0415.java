package leetcode.So04;

/**
 * 力扣0415每日一题，题目编号213
 *
 * 【不会做】
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张佳乐
 * @date 2021/4/15 17:24
 **/
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1){ return nums[0]; }
        if(len == 2){ return Math.max(nums[0], nums[1]); }
        int[] dp = new int[len];

        return Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}

/**
 * @author 张佳乐
 */
public class So0415 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.rob(new int[]{1,2,3,4,5,6,7,10});
        System.out.println(i);
    }
}
