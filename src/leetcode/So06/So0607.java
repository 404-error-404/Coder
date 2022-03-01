package leetcode.So06;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/6/7 16:22
 */
public class So0607 {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        addOneNum(nums, target, 0, 0);
        return count;
    }

    public void addOneNum(int[] nums, int target, int sum, int index){
        if(index == nums.length) {
            if (sum == target) {
                count++;
            }
        }
        else {
            addOneNum(nums, target, sum + nums[index], index + 1);
            addOneNum(nums, target, sum - nums[index], index + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        System.out.println(
                new So0607().findTargetSumWays(nums, target)
        );
    }
}
