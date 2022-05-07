package leetcode.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * ·只使用数字1到9
 * ·每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/7 15:55
 **/
public class So216组合总和Ⅲ {
    List<List<Integer>> res;
    Set<Integer> set;
    int curSum = 0;

    void backtracking(int k, int n, int i) {
        if (k == 0 && curSum == n) {
            res.add(new ArrayList<>(set));
        }
        if (curSum > n || i > 9) {
            return;
        }

        for (; i <= 10 - k; i++) {
            set.add(i);
            curSum += i;
            backtracking(k - 1, n, i + 1);
            set.remove(i);
            curSum -= i;
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        set = new HashSet<>();
        curSum = 0;
        backtracking(k, n, 1);
        return res;
    }
}
