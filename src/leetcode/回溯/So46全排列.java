package leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/8 19:01
 **/
public class So46全排列 {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    // TODO 经典题目，使用used去记录某个元素是否已经使用过
    boolean[] used;

    public void dfs(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;

            dfs(nums);

            used[i] = false;
            path.removeLast();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        used = new boolean[nums.length];
        dfs(nums);
        return res;
    }
}
