package leetcode.回溯;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/8 17:58
 **/
public class So78子集 {
    List<List<Integer>> res;
    List<Integer> path;

    public void dfs(int[] nums, int idx) {
        res.add(new ArrayList<>(path));

        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();

        dfs(nums, 0);
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }
}
