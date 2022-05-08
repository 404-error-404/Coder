package leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/8 19:12
 **/
public class So47全排列Ⅱ {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    boolean[] used;

    public void dfs(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }

        int last = 11;
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || nums[i] == last) {
                continue;
            }

            path.add(nums[i]);
            used[i] =  true;
            last = nums[i];

            dfs(nums);

            used[i] = false;
            path.removeLast();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        path = new LinkedList<>();
        used = new boolean[nums.length];

        dfs(nums);

        return res;
    }
}
