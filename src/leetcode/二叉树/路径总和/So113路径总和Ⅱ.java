package leetcode.二叉树.路径总和;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/3 11:41
 */
public class So113路径总和Ⅱ {
    public void solution(TreeNode root, int curSum, int targetSum, List<Integer> path, List<List<Integer>> res) {
        curSum += root.val;
        path.add(root.val);
        if (null == root.left && null == root.right) {
            if (curSum == targetSum) {
                res.add(new ArrayList<>(path));
            }
        }
        if (null != root.left) {
            solution(root.left, curSum, targetSum, path, res);
        }
        if (null != root.right) {
            solution(root.right, curSum, targetSum, path, res);
        }
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        int curSum = 0;
        solution(root, curSum, targetSum, path, res);
        return res;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.arrToTreeNode(new int[]{5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1});
        int target = 22;
        List<List<Integer>> lists = pathSum(root, target);
        lists.forEach(System.out::println);
    }
}
