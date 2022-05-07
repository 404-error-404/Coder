package leetcode.回溯;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/7 22:17
 **/
public class So40组合总和Ⅱ {
    Set<List<Integer>> res;
    Stack<Integer> stack;

    public void backtracking(int[] nums, int target, int idx, int curSum) {
        if (curSum == target) {
            res.add(new ArrayList<>(stack));
            return;
        } else if (curSum > target || idx == nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            // 在同一层中避免使用重复元素
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            int tmp = nums[i];
            stack.add(tmp);

            backtracking(nums, target, i + 1, curSum + tmp);

            stack.pop();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new HashSet<>();
        stack = new Stack<>();

        Arrays.sort(candidates);

        backtracking(candidates, target, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();
        res.forEach(i -> ans.add(new ArrayList<>(i)));
        return ans;
    }

    @Test
    public void test() {
        int[] c = new int[]{5, 1, 3, 3};
        int target = 6;
        List<List<Integer>> lists = combinationSum2(c, target);
        System.out.println(lists);
    }

}
