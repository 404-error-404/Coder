package leetcode.SoByNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张佳乐
 * @date 2021/9/16 15:58
 */
public class So1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{i, map.get(target-nums[i])};
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int target = 9;
        int[] nums = new int[]{2,7,11,15};
        int[] res = new So1().twoSum(nums, target);
        for (int i: res){
            System.out.println(i);
        }
    }
}
