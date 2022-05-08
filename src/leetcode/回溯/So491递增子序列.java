package leetcode.回溯;

import java.util.*;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * <p>
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/8 18:37
 **/
public class So491递增子序列 {
    Set<List<Integer>> res;
    LinkedList<Integer> path;

    public void dfs(int[] nums, int idx) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i-1]){
                continue;
            }

            if (path.size() == 0 || nums[i] >= path.getLast()) {
                path.add(nums[i]);
                dfs(nums, i + 1);
                path.removeLast();
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new HashSet<>();
        path = new LinkedList<>();

        dfs(nums, 0);

        return new ArrayList<>(res);
    }
}
