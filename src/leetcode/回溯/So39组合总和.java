package leetcode.回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/7 17:53
 **/
public class So39组合总和 {
    List<List<Integer>> res;
    Stack<Integer> stack;
    int sum;

    public void backtracking(int[] candidates, int target, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            stack.add(candidates[i]);
            sum += candidates[i];

            backtracking(candidates, target, i);

            stack.pop();
            sum -= candidates[i];
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        stack = new Stack<>();
        sum = 0;

        backtracking(candidates, target, 0);

        return res;
    }
}
