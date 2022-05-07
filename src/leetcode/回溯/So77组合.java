package leetcode.回溯;

import java.util.*;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/7 15:26
 **/
public class So77组合 {
    List<List<Integer>> res;
    Stack<Integer> stack;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        stack = new Stack<>();
        backtracking(n, k, 1);
        return res;
    }

    void backtracking(int n, int k, int i) {
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (; i <= n - k + stack.size() + 1; i++) {
            stack.add(i);
            backtracking(n, k, i + 1);
            stack.pop();
        }
    }
}
